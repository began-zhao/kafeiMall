package com.kafeimall.order.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: zzg
 * @date: 10/13/22
 * @Description: 订单项实体
 */
@Table(name = "oms_order_item")
public class OrderItemDO implements Serializable {

    private static final long serialVersionUID = 185667904172790535L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * order_id
     */
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderDO order;
    /**
     * order_sn
     */
    @Column(columnDefinition = "varchar(50)")
    private String orderSn;
    /**
     * spu_id
     */
    @Column(columnDefinition = "bigint")
    private Long spuId;
    /**
     * spu_name
     */
    @Column(columnDefinition = "varchar(255)")
    private String spuName;
    /**
     * spu_pic
     */
    @Column(columnDefinition = "varchar(500)")
    private String spuPic;
    /**
     * 品牌
     */
    @Column(columnDefinition = "varchar(255)")
    private String spuBrand;
    /**
     * 商品分类id
     */
    @Column(columnDefinition = "bigint")
    private Long categoryId;
    /**
     * 商品sku编号
     */
    @Column(columnDefinition = "bigint")
    private Long skuId;
    /**
     * 商品sku名字
     */
    @Column(columnDefinition = "varchar(255)")
    private String skuName;
    /**
     * 商品sku图片
     */
    @Column(columnDefinition = "varchar(500)")
    private String skuPic;
    /**
     * 商品sku价格
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal skuPrice;
    /**
     * 商品购买的数量
     */
    @Column(columnDefinition = "int")
    private Integer skuQuantity;
    /**
     * 商品销售属性组合（JSON）
     */
    @Column(columnDefinition = "varchar(500)")
    private String skuAttrsVals;
    /**
     * 商品促销分解金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal promotionAmount;
    /**
     * 优惠券优惠分解金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal couponAmount;
    /**
     * 积分优惠分解金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal integrationAmount;
    /**
     * 该商品经过优惠后的分解金额
     */
    @Column(columnDefinition = "decimal(18,5)")
    private BigDecimal realAmount;
    /**
     * 赠送积分
     */
    @Column(columnDefinition = "int")
    private Integer giftIntegration;
    /**
     * 赠送成长值
     */
    @Column(columnDefinition = "int")
    private Integer giftGrowth;

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

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuPic() {
        return spuPic;
    }

    public void setSpuPic(String spuPic) {
        this.spuPic = spuPic;
    }

    public String getSpuBrand() {
        return spuBrand;
    }

    public void setSpuBrand(String spuBrand) {
        this.spuBrand = spuBrand;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuPic() {
        return skuPic;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(Integer skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

    public String getSkuAttrsVals() {
        return skuAttrsVals;
    }

    public void setSkuAttrsVals(String skuAttrsVals) {
        this.skuAttrsVals = skuAttrsVals;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }
}
