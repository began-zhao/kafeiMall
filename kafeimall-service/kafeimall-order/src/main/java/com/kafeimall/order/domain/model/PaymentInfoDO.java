package com.kafeimall.order.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: zzg
 * @LocalDateTime: 10/13/22
 * @Description: 支付信息表
 */
@Table(name = "oms_payment_info")
public class PaymentInfoDO implements Serializable {
    private static final long serialVersionUID = -6608522775715054579L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 订单号（对外业务号）
     */
    @Column(columnDefinition = "varchar(50)")
    private String orderSn;
    /**
     * 订单id
     */
    @Column(columnDefinition = "bigint")
    private Long orderId;
    /**
     * 支付宝交易流水号
     */
    @Column(columnDefinition = "varchar(50)")
    private String alipayTradeNo;
    /**
     * 支付总金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal totalAmount;
    /**
     * 交易内容
     */
    @Column(columnDefinition = "varchar(50)")
    private String subject;
    /**
     * 支付状态
     */
    @Column(columnDefinition = "int")
    private Integer paymentStatus;
    /**
     * 创建时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime createTime;
    /**
     * 确认时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime confirmTime;
    /**
     * 回调内容
     */
    @Column(columnDefinition = "varchar(500)")
    private String callbackContent;
    /**
     * 回调时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime callbackTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getCallbackContent() {
        return callbackContent;
    }

    public void setCallbackContent(String callbackContent) {
        this.callbackContent = callbackContent;
    }

    public LocalDateTime getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(LocalDateTime callbackTime) {
        this.callbackTime = callbackTime;
    }
}
