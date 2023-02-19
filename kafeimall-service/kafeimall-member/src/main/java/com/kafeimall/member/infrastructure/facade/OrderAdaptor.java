package com.kafeimall.member.infrastructure.facade;

import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author: zzg
 * @date: 9/26/22
 * @Description: 订单Feign调用
 */
@FeignClient("kafeimall-order")
public interface OrderAdaptor {
    @PostMapping("/order/order/listWithItem")
    Result listWithItem(@RequestBody Map<String, Object> params);
}
