package com.kafeimall.auth.httpapi;

import com.kafeimall.auth.infrastructure.facade.MemberAdaptor;
import com.kafeimall.auth.infrastructure.facade.ThirdPartAdaptor;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserLoginVo;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: 处理登录请求
 */
@Controller
public class LoginController {
    @Resource
    ThirdPartAdaptor thirdPartFeignService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Resource
    MemberAdaptor memberFeignService;

    @ResponseBody
    @GetMapping("/sms/sendCode")
    public R sendCode(@RequestParam("phone") String phone) {
        String s = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (!StringUtils.isEmpty(s)) {
            Long s1 = Long.parseLong(s.split("_")[1]);
            long l = System.currentTimeMillis() - s1;
            if (l < 60000) {
                //60秒以内不能再发
                return R.error(BizCodeEnume.SMS_CODE_EXCEPTION.getCode(), BizCodeEnume.SMS_CODE_EXCEPTION.getMessage());
            }
        }
        //1、接口防刷

        //2、验证码的再次校验


        String code = UUID.randomUUID().toString().substring(0, 5);
        String redisValue = code + "_" + System.currentTimeMillis();
        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone, redisValue, 5, TimeUnit.MINUTES);
        R r = thirdPartFeignService.sendCode(phone, code);
        return R.ok();
    }

    /**
     * //TODO 重定向携带数据，利用session原理，将数据放在session中，只要跳转到下一个页面取出这个数据后，session里面的数据就会删除掉
     * //TODO 分布式下的session问题
     * <p>
     * 验证注册信息，开始注册
     *
     * @param vo     传入数据并验证
     * @param result 数据验证结果
     * @return
     * @redirectAttributes 重定向携带数据
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:20000/register.html";
        }


        //1、校验验证码
        String code = vo.getCode();

        String s = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
        if (!StringUtils.isEmpty(s)) {
            if (code.equals(s.split("_")[0])) {
                //删除验证码;令牌机制
                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());

                //调用远程服务开始注册
                R r = memberFeignService.regist(vo);
                if (r.getCode() == 0) {
                    //注册成功回到首页，回到登录页
//                    return "redirect:http:auth.gulimall.com/login.html";//ngnix重定向需要带上域名
                    return "redirect:/login.html";
                } else {
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg", r.getData("msg", new TypeReference<String>() {
                    }));
                    redirectAttributes.addFlashAttribute("errors", errors);
                    return "redirect:http://localhost:20000/register.html";
                }
            } else {
                Map<String, String> errors = new HashMap<>();
                errors.put("code", "验证码失效");
                redirectAttributes.addFlashAttribute("errors", errors);
                return "redirect:http://localhost:20000/register.html";
            }

        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("code", "验证码失效");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:20000/register.html";
        }


    }

    /**
     * 自定义视图映射
     *
     * @return
     */
    @GetMapping("/login.html")
    public String loginPage(HttpSession session) {

        Object attribute = session.getAttribute(AuthServerConstant.LOGIN_USER);
        if (attribute == null) {
            //没登录
            return "login";
        } else {
            //已登录
            return "redirect:http://gulimall.com:10000/";
        }
    }

    @PostMapping("/login")
    public String login(UserLoginVo vo, RedirectAttributes redirectAttributes, HttpSession session) {
        //远程登录

        R login = memberFeignService.login(vo);
        if (login.getCode() == 0) {
            MemberRespVo data = login.getData("data", new TypeReference<MemberRespVo>() {
            });
            //登录成功放到session中
            session.setAttribute(AuthServerConstant.LOGIN_USER, data);
//            return "redirect:http://localhost:10000/";
            return "redirect:http://gulimall.com:10000/";
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", login.getData("msg", new TypeReference<String>() {
            }));
            redirectAttributes.addFlashAttribute("errors", errors);
//            return "redirect:http:auth.gulimall.com/login.html";//ngnix重定向需要带上域名
            return "redirect:/login.html";
        }
    }


}
