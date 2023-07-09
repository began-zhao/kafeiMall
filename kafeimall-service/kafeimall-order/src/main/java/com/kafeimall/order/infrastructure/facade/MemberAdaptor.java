package com.kafeimall.order.infrastructure.facade;

import com.kafeimall.order.api.contract.response.MemberAddressResponse;

import java.util.List;

/**
 * @author: zzg
 * @date: 11/2/22
 * @Description: 远程调用会员服务获取会员信息
 */
public interface MemberAdaptor {

    List<MemberAddressResponse> getAddress(Long userId);
}
