package com.kafeimall.member.application;

import com.kafeimall.common.auth.UserDto;
import com.kafeimall.common.result.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zzg
 * @date: 9/26/22
 * @Description: 会员应用层
 */
public interface MemberApplicationService {
    /**
     * 登录后获取token
     * */
    Result login(String username,String password);

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);
    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);
}
