package com.kafeimall.member.infrastructure.facade;

import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: zzg
 * @date: 2022/10/2
 * @Description: zzg
 */
@FeignClient("mall-auth")
public interface AuthAdaptor {

    @PostMapping(value = "/oauth/token")
    Result getAccessToken(@RequestParam Map<String, String> params);
}
