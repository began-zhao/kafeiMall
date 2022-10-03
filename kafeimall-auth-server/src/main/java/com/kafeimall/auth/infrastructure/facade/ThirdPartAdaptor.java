package com.kafeimall.auth.infrastructure.facade;

import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: zzg
 */
@FeignClient("mall-third-party")
public interface ThirdPartAdaptor {
    @GetMapping("/sms/sendCode")
    public Result sendCode(@RequestParam("phone")String phone, @RequestParam("code") String  code);
}
