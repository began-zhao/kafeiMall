package com.kafeimall.order.infrastructure.interceptor;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import com.kafeimall.common.auth.UserDto;
import com.kafeimall.common.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zzg
 * @date: 10/21/22
 * @Description: 用户token信息拦截并解析
 */
@Component
public class LoginUserInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserDto> LoginUser = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从Header中获取用户信息
        String userStr = request.getHeader("user");
        if(userStr == null){
            throw new ServiceException("请登录");
        }
        JSONObject userJsonObject = new JSONObject(userStr);
        UserDto userDTO = new UserDto();
        userDTO.setUsername(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toLong(userJsonObject.get("id")));
        userDTO.setRoles(Convert.toList(String.class,userJsonObject.get("authorities")));
        LoginUser.set(userDTO);
        return true;
    }
}
