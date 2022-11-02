package com.kafeimall.order.infrastructure.facade;

import com.kafeimall.order.domain.entity.CurrentUserCartItems;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: zzg
 * @date: 11/2/22
 * @Description: zzg
 */
@FeignClient("kafeimall-cart")
public interface CartFeignAdaptor {
    @GetMapping("/currentUserCartItems")
    List<CurrentUserCartItems> getCurrentUserCartItems();
}
