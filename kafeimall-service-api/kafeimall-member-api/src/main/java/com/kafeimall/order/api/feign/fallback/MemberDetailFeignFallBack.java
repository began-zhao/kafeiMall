package com.kafeimall.order.api.feign.fallback;

import com.kafeimall.order.api.contract.response.MemberAddressResponse;
import com.kafeimall.order.api.feign.MemberDetailFeign;
import org.springframework.stereotype.Component;

/**
 * @author: zzg
 * @date: 2023/7/9
 * @Description: zzg
 */
@Component
public class MemberDetailFeignFallBack implements MemberDetailFeign {
    @Override
    public MemberAddressResponse getAddress(Long userId) {
//        return Wrapper.fail(ResponseCode.SERVICE_MERCHANT_MEMBER_ERROR);
        //服务限流
        return null;
    }
}
