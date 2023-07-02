package com.kafeimall.order.infrastructure.facade;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: zzg
 * @date: 11/2/22
 * @Description: 购物车防腐层
 */
@FeignClient("kafeimall-cart")
public interface CartFeignAdaptor {
//    @GetMapping("/currentUserCartItems")
//    List<CurrentUserCartItems> getCurrentUserCartItems();
}
