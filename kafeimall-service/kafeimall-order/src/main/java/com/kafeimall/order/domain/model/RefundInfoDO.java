package com.kafeimall.order.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: zzg
 * @date: 10/13/22
 * @Description: 退款信息表
 */
@Table(name = "oms_refund_info")
public class RefundInfoDO implements Serializable {
    private static final long serialVersionUID = -7647669125511134854L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 退款的订单
     */
    @JsonBackReference
    @OneToOne(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
    @JoinColumn(name = "order_return_id",referencedColumnName = "id")
    private OrderDO order;
    /**
     * 退款金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal refund;
    /**
     * 退款交易流水号
     */
    @Column(columnDefinition = "varchar(50)")
    private String refundSn;
    /**
     * 退款状态
     */
    @Column(columnDefinition = "int")
    private Integer refundStatus;
    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @Column(columnDefinition = "int")
    private Integer refundChannel;
    /**
     *
     */
    @Column(columnDefinition = "varchar(500)")
    private String refundContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDO getOrder() {
        return order;
    }

    public void setOrder(OrderDO order) {
        this.order = order;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(Integer refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundContent() {
        return refundContent;
    }

    public void setRefundContent(String refundContent) {
        this.refundContent = refundContent;
    }
}
