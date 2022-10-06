package com.kafeimall.member.service;

import com.kafeimall.member.domain.aggregate.MemberAggregate;

/**
 * @author: zzg
 * @date: 2022/10/5
 * @Description: 会员领域服务
 */
public interface MemberDomainService {
    void registerUser(MemberAggregate memberAggregate);
}
