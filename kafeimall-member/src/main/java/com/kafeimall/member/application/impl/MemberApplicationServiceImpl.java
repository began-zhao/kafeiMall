package com.kafeimall.member.application.impl;

import cn.hutool.core.util.StrUtil;
import com.kafeimall.common.auth.AuthConstant;
import com.kafeimall.common.exception.ServiceException;
import com.kafeimall.common.result.Result;
import com.kafeimall.member.application.MemberApplicationService;
import com.kafeimall.member.infrastructure.facade.AuthAdaptor;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zzg
 * @date: 2022/10/2
 * @Description: zzg
 */
@Service
public class MemberApplicationServiceImpl implements MemberApplicationService {

    @Autowired
    private AuthAdaptor authService;

    @Override
    public Result login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
          throw new ServiceException("用户名或密码不能为空");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.PORTAL_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        return authService.getAccessToken(params);
    }
}
