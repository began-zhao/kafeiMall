package com.kafeimall.member.infrastructure.repo.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kafeimall.common.exception.ServiceException;
import com.kafeimall.member.domain.aggregate.MemberAggregate;
import com.kafeimall.member.infrastructure.repo.dao.MemberDao;
import com.kafeimall.member.infrastructure.repo.dao.po.MemberPo;
import com.kafeimall.member.infrastructure.repo.repository.MemberRepository;
import com.kafeimall.member.infrastructure.repo.repository.converter.MemberRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zzg
 * @date: 2022/10/5
 * @Description: zzg
 */
@Service("MemberRepository")
public class MemberRepositoryImpl extends ServiceImpl<MemberDao,MemberPo> implements MemberRepository {

    @Autowired
    MemberRepositoryConverter memberRepositoryConverter;

    public void checkUserUnique(String phone, String username)
    {
        Long aLong = baseMapper.selectCount(new QueryWrapper<MemberPo>().eq("mobile", phone));
        if(aLong>0){
            throw new ServiceException("手机号码已存在");
        }
        Long bLong = baseMapper.selectCount(new QueryWrapper<MemberPo>().eq("username", username));
        if(bLong>0){
            throw new ServiceException("用户名已存在");
        }
    }

    @Override
    public void registerUser(MemberAggregate memberAggregate) {
        MemberPo memberPo = memberRepositoryConverter.toMemberPO(memberAggregate);
        baseMapper.insert(memberPo);
    }

    @Override
    public MemberAggregate selectUserByUsername(String username) {
        MemberPo username1 = baseMapper.selectOne(new QueryWrapper<MemberPo>().eq("username", username));
        MemberAggregate memberAggregate = memberRepositoryConverter.toMemberDO(username1);
        return memberAggregate;
    }

}
