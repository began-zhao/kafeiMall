package com.kafeimall.member.application.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.kafeimall.common.auth.AuthConstant;
import com.kafeimall.common.auth.UserDto;
import com.kafeimall.common.exception.ServiceException;
import com.kafeimall.common.result.Result;
import com.kafeimall.member.application.MemberApplicationService;
import com.kafeimall.member.infrastructure.facade.AuthAdaptor;
import com.kafeimall.member.infrastructure.repo.repository.MemberRepository;
import com.kafeimall.member.service.MemberDomainService;
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

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDomainService memberDomainService;

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

    @Override
    public void register(String username, String password, String telephone, String authCode) {
        //1、验证验证码
//        if(!verifyAuthCode(authCode,telephone)){
//            throw new ServiceException("验证码错误");
//        }
        //2、查询是否已有该用户

        //3、没有该用户进行添加操作
        String hashpw = BCrypt.hashpw(password);
        //4、获取默认会员等级并设置

        //返回结果
        System.out.println(hashpw);
    }

    @Override
    public String generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {

    }

    @Override
    public UserDto loadUserByUsername(String username) {
        return null;
    }
    //对输入的验证码进行校验
//    private boolean verifyAuthCode(String authCode, String telephone){
//        if(StringUtils.isEmpty(authCode)){
//            return false;
//        }
//        String realAuthCode = memberCacheService.getAuthCode(telephone);
//        return authCode.equals(realAuthCode);
//    }
}
