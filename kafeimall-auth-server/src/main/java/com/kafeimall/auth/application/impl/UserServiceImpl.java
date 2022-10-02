package com.kafeimall.auth.application.impl;

import com.kafeimall.auth.constant.MessageConstant;
import com.kafeimall.auth.infrastructure.facade.UmsMemberAdaptor;
import com.kafeimall.auth.infrastructure.facade.model.vo.SecurityUser;
import com.kafeimall.common.auth.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zzg
 * @date: 9/23/22
 * @Description: 用户管理业务类
 */
@Service
public class UserServiceImpl implements UserDetailsService {
//    @Autowired
//    private UmsAdminService adminService;
    @Autowired
    private UmsMemberAdaptor memberService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto;
//        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
//            userDto = adminService.loadUserByUsername(username);
//        }else{
//            userDto = memberService.loadUserByUsername(username);
//        }
        //直接从member服务查询用户信息
        userDto = memberService.loadUserByUsername(username);
        if (userDto==null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
