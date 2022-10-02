package com.kafeimall.member.application;

import com.kafeimall.common.result.Result;

/**
 * @author: zzg
 * @date: 9/26/22
 * @Description: 会员应用层
 */
public interface MemberApplicationService {
    /**
     * 登录接口
     * */
    Result login(String username,String password);
}
