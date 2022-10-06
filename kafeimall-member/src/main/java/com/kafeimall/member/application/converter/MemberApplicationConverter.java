package com.kafeimall.member.application.converter;

import com.kafeimall.common.auth.UserDto;
import com.kafeimall.member.domain.aggregate.MemberAggregate;
import org.mapstruct.Mapper;

import java.util.ArrayList;

/**
 * @author: zzg
 * @date: 2022/10/6
 * @Description:  会员DO-DTO转换器
 */
@Mapper(componentModel = "spring")
public interface MemberApplicationConverter {

    default UserDto toUserDTO(MemberAggregate memberAggregate){
        UserDto userDto = new UserDto();
        userDto.setUsername(memberAggregate.getUsername());
        userDto.setClientId("portal-app");
        userDto.setId(1L);
        userDto.setStatus(1);
        userDto.setRoles(new ArrayList<>(1));
        userDto.setPassword(memberAggregate.getPassword());
        return userDto;
    };
}
