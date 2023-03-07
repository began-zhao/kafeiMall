package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 商品分类表
 */
@Table(name = "pms_category")
public class CategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    /**
     * 分类名称
     */
    @Column(columnDefinition = "char(50)")
    private String name;
    /**
     * 父分类id
     */
    @Column(columnDefinition = "bigint")
    private Long parentCid;
    /**
     * 层级
     */
    @Column(columnDefinition = "int")
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    @Column(columnDefinition = "tinyint")
    private Integer showStatus;
    /**
     * 排序
     */
    @Column(columnDefinition = "int")
    private Integer sort;
    /**
     * 图标地址
     */
    @Column(columnDefinition = "char(255)")
    private String icon;
    /**
     * 计量单位
     */
    @Column(columnDefinition = "char(50)")
    private String productUnit;
    /**
     * 商品数量
     */
    @Column(columnDefinition = "int")
    private Integer productCount;

    /**
     * 多对一关联品牌
     */
    @ManyToMany(mappedBy = "category",cascade = CascadeType.DETACH)
    @JsonBackReference
    private Set<BrandDO> brands;

    /**
     * 一对多关联商品
     */
    @OneToMany(mappedBy = "category",cascade = CascadeType.DETACH)
    @JsonManagedReference
    private Set<SpuInfoDO> spuInfos;

    /**
     * 一对多关联sku
     */
    @OneToMany(mappedBy = "category",cascade = CascadeType.DETACH)
    @JsonManagedReference
    private Set<SkuInfoDO> skuInfos;

    /**
     * 获取子分类
     *
     * @TableField 声明此属性不是在数据库中的
     */
    @Transient
    private List<CategoryDO> children;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentCid() {
        return parentCid;
    }

    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }

    public Integer getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Integer catLevel) {
        this.catLevel = catLevel;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Set<BrandDO> getBrands() {
        return brands;
    }

    public void setBrands(Set<BrandDO> brands) {
        this.brands = brands;
    }

    public Set<SpuInfoDO> getSpuInfos() {
        return spuInfos;
    }

    public void setSpuInfos(Set<SpuInfoDO> spuInfos) {
        this.spuInfos = spuInfos;
    }

    public Set<SkuInfoDO> getSkuInfos() {
        return skuInfos;
    }

    public void setSkuInfos(Set<SkuInfoDO> skuInfos) {
        this.skuInfos = skuInfos;
    }

    public List<CategoryDO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDO> children) {
        this.children = children;
    }
}
