package com.kafeimall.auth.infrastructure.facade;

import com.kafeimall.common.auth.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zzg
 * @date: 9/23/22
 * @Description: zzg
 */
@FeignClient("kafeimall-member")
public interface UmsMemberAdaptor {
    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
