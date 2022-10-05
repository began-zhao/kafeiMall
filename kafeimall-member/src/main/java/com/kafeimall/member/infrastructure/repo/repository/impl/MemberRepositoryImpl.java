package com.kafeimall.member.infrastructure.repo.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kafeimall.member.infrastructure.repo.dao.MemberDao;
import com.kafeimall.member.infrastructure.repo.dao.po.MemberPo;
import com.kafeimall.member.infrastructure.repo.repository.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * @author: zzg
 * @date: 2022/10/5
 * @Description: zzg
 */
@Service("MemberRepository")
public class MemberRepositoryImpl extends ServiceImpl<MemberDao,MemberPo> implements MemberRepository {
}
