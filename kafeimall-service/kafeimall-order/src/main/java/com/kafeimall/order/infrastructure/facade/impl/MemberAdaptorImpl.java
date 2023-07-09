package com.kafeimall.order.infrastructure.facade.impl;

import com.kafeimall.order.api.contract.response.MemberAddressResponse;
import com.kafeimall.order.api.feign.MemberDetailFeign;
import com.kafeimall.order.infrastructure.facade.MemberAdaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zzg
 * @date: 2023/7/9
 * @Description: zzg
 */
@Service
public class MemberAdaptorImpl implements MemberAdaptor {
    private static final Logger logger = LoggerFactory.getLogger(MemberAdaptorImpl.class);

    @Resource
    private MemberDetailFeign memberDetailFeign;
    @Override
    public List<MemberAddressResponse> getAddress(Long userId) {
        return memberDetailFeign.getAddress(userId);
    }
}
