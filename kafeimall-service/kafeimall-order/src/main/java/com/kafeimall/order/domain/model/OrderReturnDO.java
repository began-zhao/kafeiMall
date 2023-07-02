package com.kafeimall.order.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: zzg
 * @LocalDateTime: 10/18/22
 * @Description: 退货管理聚合
 */
@Table(name = "oms_order_return_apply")
public class OrderReturnDO implements Serializable {
    private static final long serialVersionUID = -6360757662504359656L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * order_id
     */
    @Column(columnDefinition = "bigint")
    private Long orderId;
    /**
     * 退货商品id
     */
    @Column(columnDefinition = "bigint")
    private Long skuId;
    /**
     * 订单编号
     */ 
    @Column(columnDefinition = "varchar(50)")
    private String orderSn;
    /**
     * 申请时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime createTime;
    /**
     * 会员用户名
     */
    @Column(columnDefinition = "varchar(50)")
    private String memberUsername;
    /**
     * 退款金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal returnAmount;
    /**
     * 退货人姓名
     */
    @Column(columnDefinition = "varchar(50)")
    private String returnName;
    /**
     * 退货人电话
     */
    @Column(columnDefinition = "varchar(11)")
    private String returnPhone;
    /**
     * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
     */
    @Column(columnDefinition = "int")
    private Integer status;
    /**
     * 处理时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime handleTime;
    /**
     * 商品图片
     */
    @Column(columnDefinition = "varchar(50)")
    private String skuImg;
    /**
     * 商品名称
     */
    @Column(columnDefinition = "varchar(50)")
    private String skuName;
    /**
     * 商品品牌
     */
    @Column(columnDefinition = "varchar(50)")
    private String skuBrand;
    /**
     * 商品销售属性(JSON)
     */
    @Column(columnDefinition = "varchar(500)")
    private String skuAttrsVals;
    /**
     * 退货数量
     */
    @Column(columnDefinition = "int")
    private Integer skuCount;
    /**
     * 商品单价
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal skuPrice;
    /**
     * 商品实际支付单价
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal skuRealPrice;
    /**
     * 原因
     */
    @Column(columnDefinition = "varchar(50)")
    private String reason;
    /**
     * 描述
     */
    @Column(columnDefinition = "varchar(500)")
    private String description;
    /**
     * 凭证图片，以逗号隔开
     */
    @Column(columnDefinition = "varchar(500)")
    private String descPics;
    /**
     * 处理备注
     */
    @Column(columnDefinition = "varchar(500)")
    private String handleNote;
    /**
     * 处理人员
     */
    @Column(columnDefinition = "varchar(50)")
    private String handleMan;
    /**
     * 收货人
     */
    @Column(columnDefinition = "varchar(500)")
    private String receiveMan;
    /**
     * 收货时间
     */
    @Column(columnDefinition = "timestamp")
    private LocalDateTime receiveTime;
    /**
     * 收货备注
     */
    @Column(columnDefinition = "varchar(500)")
    private String receiveNote;
    /**
     * 收货电话
     */
    @Column(columnDefinition = "varchar(11)")
    private String receivePhone;
    /**
     * 公司收货地址
     */
    @Column(columnDefinition = "varchar(500)")
    private String companyAddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
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

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(LocalDateTime handleTime) {
        this.handleTime = handleTime;
    }

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuBrand() {
        return skuBrand;
    }

    public void setSkuBrand(String skuBrand) {
        this.skuBrand = skuBrand;
    }

    public String getSkuAttrsVals() {
        return skuAttrsVals;
    }

    public void setSkuAttrsVals(String skuAttrsVals) {
        this.skuAttrsVals = skuAttrsVals;
    }

    public Integer getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getSkuRealPrice() {
        return skuRealPrice;
    }

    public void setSkuRealPrice(BigDecimal skuRealPrice) {
        this.skuRealPrice = skuRealPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescPics() {
        return descPics;
    }

    public void setDescPics(String descPics) {
        this.descPics = descPics;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
