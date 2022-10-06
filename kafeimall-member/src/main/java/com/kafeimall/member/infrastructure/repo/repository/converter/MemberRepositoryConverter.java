package com.kafeimall.member.infrastructure.repo.repository.converter;

import com.kafeimall.member.domain.aggregate.MemberAggregate;
import com.kafeimall.member.infrastructure.repo.dao.po.MemberPo;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 2022/10/6
 * @Description: MemberPO-DO转换器
 */
@Mapper(componentModel = "spring")
public interface MemberRepositoryConverter {

    MemberAggregate toMemberDO(MemberPo memberPo);

    MemberPo toMemberPO(MemberAggregate memberAggregate);
}
