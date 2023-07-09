package com.kafeimall.order.api.feign;

import com.kafeimall.order.api.contract.response.MemberAddressResponse;
import com.kafeimall.order.api.feign.fallback.MemberDetailFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: zzg
 * @date: 2023/7/9
 * @Description: zzg
 */
@FeignClient(name = "member-service", fallback = MemberDetailFeignFallBack.class)
public interface MemberDetailFeign {


     @GetMapping(value = "/member/feign/detail/get")
     List<MemberAddressResponse> getAddress(Long userId);
}
