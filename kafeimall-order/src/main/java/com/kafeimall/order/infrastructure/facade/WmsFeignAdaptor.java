package com.kafeimall.order.infrastructure.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author: zzg
 * @date: 11/4/22
 * @Description: 远程调用库存服务
 */
@FeignClient(value = "kafeimall-ware")
public interface WmsFeignAdaptor {

    @PostMapping("/ware/waresku/hasstock")
    Map<Long,Boolean> getSkusHasStock(@RequestBody List<Long> skuIds);

    @GetMapping("/ware/wareinfo/fare")
    void getFare(@RequestParam("addrId")Long addrId);

//    @PostMapping("/ware/waresku/lock/order")
//    void orderLockStock(@RequestBody WareSkuLockVo vo);
}
