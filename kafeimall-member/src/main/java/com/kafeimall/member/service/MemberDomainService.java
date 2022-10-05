package com.kafeimall.member.service;

import com.kafeimall.member.domain.aggregate.MemberAggregate;

/**
 * @author: zzg
 * @date: 2022/10/5
 * @Description: zzg
 */
public interface MemberDomainService {
    void registerUser(MemberAggregate memberAggregate);
}
