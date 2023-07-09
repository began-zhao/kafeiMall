package com.kafeimall.order.domain.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.order.domain.model.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单服务资源层
 */
public interface OrderRepository extends JpaRepository<OrderDO,Long>, JpaSpecificationExecutor<OrderDO> , IRepository<OrderDO> {

    /**
     * 获取ID对应订单
     */
    OrderDO getOrderDOById(Long id);

    /**
     * 获取用户对应订单
     */
    List<OrderDO> getOrderDOByMemberId(Long uId);

    /**
     * 根据订单号获取订单
     */
    OrderDO getOrderDOByOrderSn(String orderNo);


}
