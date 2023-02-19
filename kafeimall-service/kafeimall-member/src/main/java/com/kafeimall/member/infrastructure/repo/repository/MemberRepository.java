package com.kafeimall.member.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.member.domain.aggregate.MemberAggregate;

/**
 * @author: zzg
 * @date: 9/26/22
 * @Description: 会员资源层
 */
public interface MemberRepository extends IRepository<MemberAggregate> {
    //检测是否存在用户
    void checkUserUnique(String phone,String username);

    //注册用户
    void registerUser(MemberAggregate memberAggregate);

    //检测是否存在用户
    MemberAggregate selectUserByUsername(String username);
}
