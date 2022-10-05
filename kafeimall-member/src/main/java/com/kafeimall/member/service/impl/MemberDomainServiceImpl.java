package com.kafeimall.member.service.impl;

import com.kafeimall.member.domain.aggregate.MemberAggregate;
import com.kafeimall.member.infrastructure.repo.repository.MemberRepository;
import com.kafeimall.member.service.MemberDomainService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zzg
 * @date: 2022/10/5
 * @Description: zzg
 */
public class MemberDomainServiceImpl implements MemberDomainService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void registerUser(MemberAggregate memberAggregate) {

    }
}
