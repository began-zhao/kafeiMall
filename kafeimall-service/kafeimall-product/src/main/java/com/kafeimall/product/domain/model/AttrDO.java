package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author: zzg
 * @date: 8/30/22
 * @Description: 商品属性
 */
@Table(name = "pms_attr")
public class AttrDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attrId;
    /**
     * 属性名
     */
    @Column(columnDefinition = "char(30)")
    private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @Column(columnDefinition = "int")
    private Integer searchType;
    /**
     * 属性图标
     */
    @Column(columnDefinition = "varchar(255)")
    private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
    @Column(columnDefinition = "varchar(255)")
    private String valueSelect;
    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @Column(columnDefinition = "int")
    private Integer attrType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @Column(columnDefinition = "bigint")
    private Long enable;
    /**
     * 所属分类
     */
    @Column(columnDefinition = "bigint")
    private Long catelogId;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @Column(columnDefinition = "tinyint")
    private Integer showDesc;

    /**
     * 多对多关联属性分组
     */
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "pms_attr_attrgroup_relation",joinColumns = {@JoinColumn(name = "attr_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "attr_group_id",referencedColumnName = "id")})
    private Set<AttrGroupDO> attrGroups;


    /**
     * sku销售属性
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "attr",cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
    private Set<SkuSaleAttrValueDO> skuSaleAttrValues;

    /**
     * spu销售属性
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "attr",cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
    private Set<ProductAttrValueDO> productAttrValues;

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getValueSelect() {
        return valueSelect;
    }

    public void setValueSelect(String valueSelect) {
        this.valueSelect = valueSelect;
    }

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    public Long getEnable() {
        return enable;
    }

    public void setEnable(Long enable) {
        this.enable = enable;
    }

    public Long getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    public Integer getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(Integer showDesc) {
        this.showDesc = showDesc;
    }

    public Set<AttrGroupDO> getAttrGroups() {
        return attrGroups;
    }

    public void setAttrGroups(Set<AttrGroupDO> attrGroups) {
        this.attrGroups = attrGroups;
    }

    public Set<SkuSaleAttrValueDO> getSkuSaleAttrValues() {
        return skuSaleAttrValues;
    }

    public void setSkuSaleAttrValues(Set<SkuSaleAttrValueDO> skuSaleAttrValues) {
        this.skuSaleAttrValues = skuSaleAttrValues;
    }

    public Set<ProductAttrValueDO> getProductAttrValues() {
        return productAttrValues;
    }

    public void setProductAttrValues(Set<ProductAttrValueDO> productAttrValues) {
        this.productAttrValues = productAttrValues;
    }
}
