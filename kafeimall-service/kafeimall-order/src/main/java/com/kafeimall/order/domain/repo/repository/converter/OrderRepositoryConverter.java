package com.kafeimall.order.domain.repo.repository.converter;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.entity.OrderItem;
import com.kafeimall.order.domain.repo.dao.po.OrderItemPO;
import com.kafeimall.order.domain.repo.dao.po.OrderPO;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 10/18/22
 * @Description: 订单DO-PO转换器
 */
@Mapper(componentModel = "spring")
public interface OrderRepositoryConverter {

    default OrderAggregate toOrderDo(OrderPO orderPO, List<OrderItemPO> orderItemPOS) {
        OrderAggregate orderAggregate = new OrderAggregate();
        orderAggregate.setId(orderPO.getId());
        orderAggregate.setMemberId(orderPO.getMemberId());
        orderAggregate.setOrderSn(orderPO.getOrderSn());
        orderAggregate.setCouponId(orderPO.getCouponId());
        orderAggregate.setCreateTime(orderPO.getCreateTime());
        orderAggregate.setMemberUsername(orderPO.getMemberUsername());
        orderAggregate.setTotalAmount(orderPO.getTotalAmount());
        orderAggregate.setPayAmount(orderPO.getPayAmount());
        orderAggregate.setFreightAmount(orderPO.getFreightAmount());
        orderAggregate.setPromotionAmount(orderPO.getPromotionAmount());
        orderAggregate.setIntegrationAmount(orderPO.getIntegrationAmount());
        orderAggregate.setCouponAmount(orderPO.getCouponAmount());
        orderAggregate.setDiscountAmount(orderPO.getDiscountAmount());
        orderAggregate.setPayType(orderPO.getPayType());
        orderAggregate.setSourceType(orderPO.getSourceType());
        orderAggregate.setStatus(orderPO.getStatus());
        orderAggregate.setDeliveryCompany(orderPO.getDeliveryCompany());
        orderAggregate.setDeliverySn(orderPO.getDeliverySn());
        orderAggregate.setAutoConfirmDay(orderPO.getAutoConfirmDay());
        orderAggregate.setIntegration(orderPO.getIntegration());
        orderAggregate.setGrowth(orderPO.getGrowth());
        orderAggregate.setBillType(orderPO.getBillType());
        orderAggregate.setBillHeader(orderPO.getBillHeader());
        orderAggregate.setBillContent(orderPO.getBillContent());
        orderAggregate.setBillReceiverPhone(orderPO.getBillReceiverPhone());
        orderAggregate.setBillReceiverEmail(orderPO.getBillReceiverEmail());
        orderAggregate.setReceiverName(orderPO.getReceiverName());
        orderAggregate.setReceiverPhone(orderPO.getReceiverPhone());
        orderAggregate.setReceiverPostCode(orderPO.getReceiverPostCode());
        orderAggregate.setReceiverProvince(orderPO.getReceiverProvince());
        orderAggregate.setReceiverCity(orderPO.getReceiverCity());
        orderAggregate.setReceiverRegion(orderPO.getReceiverRegion());
        orderAggregate.setReceiverDetailAddress(orderPO.getReceiverDetailAddress());
        orderAggregate.setNote(orderPO.getNote());
        orderAggregate.setConfirmStatus(orderPO.getConfirmStatus());
        orderAggregate.setDeleteStatus(orderPO.getDeleteStatus());
        orderAggregate.setUseIntegration(orderPO.getUseIntegration());
        orderAggregate.setPaymentTime(orderPO.getPaymentTime());
        orderAggregate.setDeliveryTime(orderPO.getDeliveryTime());
        orderAggregate.setReceiveTime(orderPO.getReceiveTime());
        orderAggregate.setCommentTime(orderPO.getCommentTime());
        orderAggregate.setModifyTime(orderPO.getModifyTime());
        List<OrderItem> orderItemList = orderItemPOS.stream().map(e -> {
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(e, orderItem);
            return orderItem;
        }).collect(Collectors.toList());
        orderAggregate.setItemEntities(orderItemList);
        return orderAggregate;

    }

    default List<OrderAggregate> toOrderListDo(List<OrderPO> orderPOList, List<OrderItemPO> orderItemPOS) {
        List<OrderAggregate> orderAggregateList = orderPOList.stream().map(orderPO -> {
            OrderAggregate orderAggregate = new OrderAggregate();
            orderAggregate.setId(orderPO.getId());
            orderAggregate.setMemberId(orderPO.getMemberId());
            orderAggregate.setOrderSn(orderPO.getOrderSn());
            orderAggregate.setCouponId(orderPO.getCouponId());
            orderAggregate.setCreateTime(orderPO.getCreateTime());
            orderAggregate.setMemberUsername(orderPO.getMemberUsername());
            orderAggregate.setTotalAmount(orderPO.getTotalAmount());
            orderAggregate.setPayAmount(orderPO.getPayAmount());
            orderAggregate.setFreightAmount(orderPO.getFreightAmount());
            orderAggregate.setPromotionAmount(orderPO.getPromotionAmount());
            orderAggregate.setIntegrationAmount(orderPO.getIntegrationAmount());
            orderAggregate.setCouponAmount(orderPO.getCouponAmount());
            orderAggregate.setDiscountAmount(orderPO.getDiscountAmount());
            orderAggregate.setPayType(orderPO.getPayType());
            orderAggregate.setSourceType(orderPO.getSourceType());
            orderAggregate.setStatus(orderPO.getStatus());
            orderAggregate.setDeliveryCompany(orderPO.getDeliveryCompany());
            orderAggregate.setDeliverySn(orderPO.getDeliverySn());
            orderAggregate.setAutoConfirmDay(orderPO.getAutoConfirmDay());
            orderAggregate.setIntegration(orderPO.getIntegration());
            orderAggregate.setGrowth(orderPO.getGrowth());
            orderAggregate.setBillType(orderPO.getBillType());
            orderAggregate.setBillHeader(orderPO.getBillHeader());
            orderAggregate.setBillContent(orderPO.getBillContent());
            orderAggregate.setBillReceiverPhone(orderPO.getBillReceiverPhone());
            orderAggregate.setBillReceiverEmail(orderPO.getBillReceiverEmail());
            orderAggregate.setReceiverName(orderPO.getReceiverName());
            orderAggregate.setReceiverPhone(orderPO.getReceiverPhone());
            orderAggregate.setReceiverPostCode(orderPO.getReceiverPostCode());
            orderAggregate.setReceiverProvince(orderPO.getReceiverProvince());
            orderAggregate.setReceiverCity(orderPO.getReceiverCity());
            orderAggregate.setReceiverRegion(orderPO.getReceiverRegion());
            orderAggregate.setReceiverDetailAddress(orderPO.getReceiverDetailAddress());
            orderAggregate.setNote(orderPO.getNote());
            orderAggregate.setConfirmStatus(orderPO.getConfirmStatus());
            orderAggregate.setDeleteStatus(orderPO.getDeleteStatus());
            orderAggregate.setUseIntegration(orderPO.getUseIntegration());
            orderAggregate.setPaymentTime(orderPO.getPaymentTime());
            orderAggregate.setDeliveryTime(orderPO.getDeliveryTime());
            orderAggregate.setReceiveTime(orderPO.getReceiveTime());
            orderAggregate.setCommentTime(orderPO.getCommentTime());
            orderAggregate.setModifyTime(orderPO.getModifyTime());
            List<OrderItem> orderItemList = orderItemPOS.stream().map(e -> {
                OrderItem orderItem = new OrderItem();
                BeanUtils.copyProperties(e, orderItem);
                return orderItem;
            }).collect(Collectors.toList());
            orderAggregate.setItemEntities(orderItemList);
            return orderAggregate;
        }).collect(Collectors.toList());

        return orderAggregateList;
    }
}
