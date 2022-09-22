package com.kafeimall.auth.exception;

import com.kafeimall.common.result.Result;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: 全局处理Oauth2抛出的异常
 */
public class Oauth2ExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public Result handleOauth2(OAuth2Exception e) {
        return Result.error(e.getMessage());
    }
}
