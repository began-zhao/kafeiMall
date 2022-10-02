package com.kafeimall.member.infrastructure.facade;

import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author: zzg
 * @date: 2022/10/2
 * @Description: zzg
 */
@FeignClient("mall-auth")
public interface AuthAdaptor {

    @PostMapping(value = "auth/oauth/token")
    Result getAccessToken(@RequestBody Map<String, String> params);
}
