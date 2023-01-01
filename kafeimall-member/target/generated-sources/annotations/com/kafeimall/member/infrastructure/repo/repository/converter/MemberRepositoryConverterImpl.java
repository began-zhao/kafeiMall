package com.kafeimall.member.infrastructure.repo.repository.converter;

import com.kafeimall.member.domain.aggregate.MemberAggregate;
import com.kafeimall.member.infrastructure.repo.dao.po.MemberPo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T19:25:33+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class MemberRepositoryConverterImpl implements MemberRepositoryConverter {

    @Override
    public MemberAggregate toMemberDO(MemberPo memberPo) {
        if ( memberPo == null ) {
            return null;
        }

        MemberAggregate memberAggregate = new MemberAggregate();

        memberAggregate.setId( memberPo.getId() );
        memberAggregate.setLevelId( memberPo.getLevelId() );
        memberAggregate.setUsername( memberPo.getUsername() );
        memberAggregate.setPassword( memberPo.getPassword() );
        memberAggregate.setNickname( memberPo.getNickname() );
        memberAggregate.setMobile( memberPo.getMobile() );
        memberAggregate.setEmail( memberPo.getEmail() );
        memberAggregate.setHeader( memberPo.getHeader() );
        memberAggregate.setGender( memberPo.getGender() );
        memberAggregate.setBirth( memberPo.getBirth() );
        memberAggregate.setCity( memberPo.getCity() );
        memberAggregate.setJob( memberPo.getJob() );
        memberAggregate.setSign( memberPo.getSign() );
        memberAggregate.setSourceType( memberPo.getSourceType() );
        memberAggregate.setIntegration( memberPo.getIntegration() );
        memberAggregate.setGrowth( memberPo.getGrowth() );
        memberAggregate.setStatus( memberPo.getStatus() );
        memberAggregate.setCreateTime( memberPo.getCreateTime() );
        memberAggregate.setSocialUid( memberPo.getSocialUid() );
        memberAggregate.setAccessToken( memberPo.getAccessToken() );
        memberAggregate.setExpiresIn( memberPo.getExpiresIn() );

        return memberAggregate;
    }

    @Override
    public MemberPo toMemberPO(MemberAggregate memberAggregate) {
        if ( memberAggregate == null ) {
            return null;
        }

        MemberPo memberPo = new MemberPo();

        memberPo.setId( memberAggregate.getId() );
        memberPo.setLevelId( memberAggregate.getLevelId() );
        memberPo.setUsername( memberAggregate.getUsername() );
        memberPo.setPassword( memberAggregate.getPassword() );
        memberPo.setNickname( memberAggregate.getNickname() );
        memberPo.setMobile( memberAggregate.getMobile() );
        memberPo.setEmail( memberAggregate.getEmail() );
        memberPo.setHeader( memberAggregate.getHeader() );
        memberPo.setGender( memberAggregate.getGender() );
        memberPo.setBirth( memberAggregate.getBirth() );
        memberPo.setCity( memberAggregate.getCity() );
        memberPo.setJob( memberAggregate.getJob() );
        memberPo.setSign( memberAggregate.getSign() );
        memberPo.setSourceType( memberAggregate.getSourceType() );
        memberPo.setIntegration( memberAggregate.getIntegration() );
        memberPo.setGrowth( memberAggregate.getGrowth() );
        memberPo.setStatus( memberAggregate.getStatus() );
        memberPo.setCreateTime( memberAggregate.getCreateTime() );
        memberPo.setSocialUid( memberAggregate.getSocialUid() );
        memberPo.setAccessToken( memberAggregate.getAccessToken() );
        memberPo.setExpiresIn( memberAggregate.getExpiresIn() );

        return memberPo;
    }
}
