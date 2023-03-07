package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author: zzg
 * @date: 8/25/22
 * @Description: 品牌表
 */
@Table(name = "pms_brand")
public class BrandDO implements Serializable {
    private static final long serialVersionUID = 4229512363268466530L;

    /**
     * 品牌id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    /**
     * 品牌名
     */
    @Column(columnDefinition = "varchar(50)")
    private String name;
    /**
     * 品牌logo地址
     */
    @Column(columnDefinition = "varchar(2000)")
    private String logo;
    /**
     * 介绍
     */
    @Column(columnDefinition = "TEXT")
    private String descript;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @Column(columnDefinition = "tinyint")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @Column(columnDefinition = "char(1)")
    private String firstLetter;
    /**
     * 排序
     */
    @Column(columnDefinition = "int")
    private Integer sort;

    /**
     * 多对多维护和品类的关系
     */
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "pms_category_brand_relation", joinColumns = {@JoinColumn(name = "brand_id", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "cat_id", referencedColumnName = "id")})
    private Set<CategoryDO> category;

    /**
     * 一对多维护和spu的关系
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "brand",cascade = CascadeType.DETACH)
    private Set<SpuInfoDO> spuInfos;

    /**
     * 一对多维护和sku的关系
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "brand",cascade = CascadeType.DETACH)
    private Set<SkuInfoDO> skuInfos;


    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Set<CategoryDO> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryDO> category) {
        this.category = category;
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
}
