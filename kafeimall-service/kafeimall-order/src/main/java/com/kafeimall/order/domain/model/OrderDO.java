package com.kafeimall.order.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kafeimall.common.domain.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author: zzg
 * @LocalDateTime: 10/13/22
 * @Description: 订单聚合
 */
@Table(name="oms_order")
public class OrderDO extends AggregateRoot implements Serializable {
    private static final long serialVersionUID = -4821023441527126905L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * member_id
     */
    @Column(columnDefinition = "bigint")
    private Long memberId;
    /**
     * 订单号
     */
    @Column(columnDefinition = "varchar(50)")
    private String orderSn;
    /**
     * 使用的优惠券
     */
    @Column(columnDefinition = "bigint")
    private Long couponId;
    /**
     * create_time
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime createTime;
    /**
     * 用户名
     */
    @Column(columnDefinition = "varchar(50)")
    private String memberUsername;
    /**
     * 订单总额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal totalAmount;
    /**
     * 应付总额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal payAmount;
    /**
     * 运费金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal freightAmount;
    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal promotionAmount;
    /**
     * 积分抵扣金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal integrationAmount;
    /**
     * 优惠券抵扣金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal couponAmount;
    /**
     * 后台调整订单使用的折扣金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal discountAmount;
    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    @Column(columnDefinition = "int")
    private Integer payType;
    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    @Column(columnDefinition = "int")
    private Integer sourceType;
    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @Column(columnDefinition = "int")
    private Integer status;
    /**
     * 物流公司(配送方式)
     */
    @Column(columnDefinition = "varchar(50)")
    private String deliveryCompany;
    /**
     * 物流单号
     */
    @Column(columnDefinition = "varchar(50)")
    private String deliverySn;
    /**
     * 自动确认时间（天）
     */
    @Column(columnDefinition = "int")
    private Integer autoConfirmDay;
    /**
     * 可以获得的积分
     */
    @Column(columnDefinition = "int")
    private Integer integration;
    /**
     * 可以获得的成长值
     */
    @Column(columnDefinition = "int")
    private Integer growth;
    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    @Column(columnDefinition = "int")
    private Integer billType;
    /**
     * 发票抬头
     */
    @Column(columnDefinition = "varchar(50)")
    private String billHeader;
    /**
     * 发票内容
     */
    @Column(columnDefinition = "varchar(255)")
    private String billContent;
    /**
     * 收票人电话
     */
    @Column(columnDefinition = "varchar(11)")
    private String billReceiverPhone;
    /**
     * 收票人邮箱
     */
    @Column(columnDefinition = "varchar(50)")
    private String billReceiverEmail;
    /**
     * 收货人姓名
     */
    @Column(columnDefinition = "varchar(20)")
    private String receiverName;
    /**
     * 收货人电话
     */
    @Column(columnDefinition = "varchar(20)")
    private String receiverPhone;
    /**
     * 收货人邮编
     */
    @Column(columnDefinition = "varchar(10)")
    private String receiverPostCode;
    /**
     * 省份/直辖市
     */
    @Column(columnDefinition = "varchar(20)")
    private String receiverProvince;
    /**
     * 城市
     */
    @Column(columnDefinition = "varchar(20)")
    private String receiverCity;
    /**
     * 区
     */
    @Column(columnDefinition = "varchar(20)")
    private String receiverRegion;
    /**
     * 详细地址
     */
    @Column(columnDefinition = "varchar(500)")
    private String receiverDetailAddress;
    /**
     * 订单备注
     */
    @Column(columnDefinition = "varchar(500)")
    private String note;
    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    @Column(columnDefinition = "int")
    private Integer confirmStatus;
    /**
     * 删除状态【0->未删除；1->已删除】
     */
    @Column(columnDefinition = "int")
    private Integer deleteStatus;
    /**
     * 下单时使用的积分
     */
    @Column(columnDefinition = "int")
    private Integer useIntegration;
    /**
     * 支付时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime paymentTime;
    /**
     * 发货时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime deliveryTime;
    /**
     * 确认收货时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime receiveTime;
    /**
     * 评价时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime commentTime;
    /**
     * 修改时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime modifyTime;
    /**
     * 订单项实体集合
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private Set<OrderItemDO> itemEntities;


    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "refund_info_id",referencedColumnName = "id")
    private RefundInfoDO refundInfoDO;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getBillHeader() {
        return billHeader;
    }

    public void setBillHeader(String billHeader) {
        this.billHeader = billHeader;
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }

    public String getBillReceiverPhone() {
        return billReceiverPhone;
    }

    public void setBillReceiverPhone(String billReceiverPhone) {
        this.billReceiverPhone = billReceiverPhone;
    }

    public String getBillReceiverEmail() {
        return billReceiverEmail;
    }

    public void setBillReceiverEmail(String billReceiverEmail) {
        this.billReceiverEmail = billReceiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Set<OrderItemDO> getItemEntities() {
        return itemEntities;
    }

    public void setItemEntities(Set<OrderItemDO> itemEntities) {
        this.itemEntities = itemEntities;
    }

    public RefundInfoDO getRefundInfoDO() {
        return refundInfoDO;
    }

    public void setRefundInfoDO(RefundInfoDO refundInfoDO) {
        this.refundInfoDO = refundInfoDO;
    }
}
