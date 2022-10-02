package com.kafeimall.auth.infrastructure.facade;

import com.kafeimall.auth.infrastructure.facade.model.vo.SocialUser;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserLoginVo;
import com.kafeimall.auth.infrastructure.facade.model.vo.UserRegistVo;
import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: 远程注册方法
 */
@FeignClient("mall-member")
public interface MemberAdaptor {
    /**
     * 远程注册方法
     *
     * @param vo
     * @return
     */
    @PostMapping("/member/member/regist")
    Result regist(@RequestBody UserRegistVo vo);

    /**
     * 远程登录方法
     *
     * @param vo
     * @return
     */
    @PostMapping("/member/member/login")
    Result login(@RequestBody UserLoginVo vo);

    @PostMapping("/member/member/oauth2/login")
    Result oauthlogin(@RequestBody SocialUser socialUser) throws Exception;
}
