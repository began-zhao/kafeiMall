package com.kafeimall.search.domain;

import com.kafeimall.search.infrastructure.constants.ProductConstants;
import lombok.Builder;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author: zzg
 * @date: 2023/3/11
 * @Description: 商品ES Mapping
 */
@Document(indexName = ProductConstants.ES_COMMODITY_INDEX)
public class Product implements Persistable<Long> {

    /**
     * 审计字段
     */
    @Id
    @Builder.Default
    private Long id;

    /**
     * skuId
     */
    @Field(type = FieldType.Long)
    private Long skuId;

    /**
     * spuId
     */
    @Field(type = FieldType.Long)
    private Long spuId;

    /**
     * sku标题
     */
    @Field(type = FieldType.Text,analyzer = "ik_smart")
    private String skuTitle;

    /**
     * sku价格
     */
    @Field(type = FieldType.Keyword)
    private BigDecimal skuPrice;

    /**
     * sku图片
     */
    @Field(type = FieldType.Keyword)
    private String skuImg;

    /**
     * 已售数量
     */
    @Field(type = FieldType.Long)
    private Long saleCount;

    /**
     * 是否已有库存
     */
    @Field(type = FieldType.Boolean)
    private boolean hosStock;

    /**
     * 评分
     */
    @Field(type = FieldType.Long)
    private Long hotScore;

    /**
     * 品牌ID
     */
    @Field(type = FieldType.Long)
    private Long brandId;

    /**
     * 分类ID
     */
    @Field(type = FieldType.Long)
    private Long catalogId;

    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 品牌图片
     */
    @Field(type = FieldType.Keyword)
    private String brandImg;

    /**
     * 商品属性
     */
    @Field(type = FieldType.Nested)
    private List<Attr> attrs;

    //审计字段
    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant createdDate;
    @CreatedBy
    private String createdBy;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    @LastModifiedDate
    private Instant lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    public boolean isHosStock() {
        return hosStock;
    }

    public void setHosStock(boolean hosStock) {
        this.hosStock = hosStock;
    }

    public Long getHotScore() {
        return hotScore;
    }

    public void setHotScore(Long hotScore) {
        this.hotScore = hotScore;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null || (createdDate == null && createdBy == null);
    }
}
