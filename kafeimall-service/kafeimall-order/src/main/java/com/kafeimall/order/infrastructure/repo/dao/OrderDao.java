package com.kafeimall.order.infrastructure.repo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kafeimall.order.infrastructure.repo.dao.po.OrderPO;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: zzg
 */
public interface OrderDao extends BaseMapper<OrderPO> {
    List<OrderPO> selectByUId(Long UId);

    OrderPO selectByOrderNo(String orderNo);
}
