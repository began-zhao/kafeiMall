package com.kafeimall.member.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.member.domain.aggregate.MemberAggregate;
import com.kafeimall.member.infrastructure.repo.dao.po.MemberPo;

/**
 * @author: zzg
 * @date: 9/26/22
 * @Description: zzg
 */
public interface MemberRepository extends IRepository<MemberPo> {
    //检测是否存在用户
    void checkUserUnique(String phone,String username);

    //注册用户
    void registerUser(MemberAggregate memberAggregate);

    //检测是否存在用户
    MemberAggregate selectUserByUsername(String username);
}
