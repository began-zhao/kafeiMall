package com.kafeimall.order.infrastructure.facade;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: zzg
 * @date: 11/2/22
 * @Description: 远程调用会员服务获取会员信息
 */
@FeignClient(value = "kafeimall-member")
public interface MemberAdaptor {

//    @GetMapping("/sku/seckill/{userId}")
//    List<MemberAddress> getAddress(@PathVariable("userId") Long userId);
}
