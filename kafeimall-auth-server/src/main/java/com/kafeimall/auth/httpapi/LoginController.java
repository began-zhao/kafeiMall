package com.kafeimall.auth.httpapi;

import com.kafeimall.auth.infrastructure.facade.MemberAdaptor;
import com.kafeimall.auth.infrastructure.facade.ThirdPartAdaptor;
import com.kafeimall.auth.infrastructure.facade.model.vo.Oauth2TokenVo;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserLoginVo;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserRegistVo;
import com.kafeimall.common.auth.AuthConstant;
import com.kafeimall.common.result.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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


    @Autowired
    private TokenEndpoint tokenEndpoint;

//    @ApiOperation("Oauth2获取token")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Result<Oauth2TokenVo> postAccessToken(HttpServletRequest request,
                                                       @ApiParam("授权模式") @RequestParam String grant_type,
                                                       @ApiParam("Oauth2客户端ID") @RequestParam String client_id,
                                                       @ApiParam("Oauth2客户端秘钥") @RequestParam String client_secret,
                                                       @ApiParam("刷新token") @RequestParam(required = false) String refresh_token,
                                                       @ApiParam("登录用户名") @RequestParam(required = false) String username,
                                                       @ApiParam("登录密码") @RequestParam(required = false) String password) throws HttpRequestMethodNotSupportedException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type",grant_type);
        parameters.put("client_id",client_id);
        parameters.put("client_secret",client_secret);
        parameters.putIfAbsent("refresh_token",refresh_token);
        parameters.putIfAbsent("username",username);
        parameters.putIfAbsent("password",password);
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(request.getUserPrincipal(), parameters).getBody();
        Oauth2TokenVo oauth2TokenDto = Oauth2TokenVo.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();

        return Result.success(oauth2TokenDto);
    }

}
