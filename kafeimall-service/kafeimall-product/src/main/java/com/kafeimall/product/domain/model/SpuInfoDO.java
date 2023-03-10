package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * spu信息
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:46
 */
@Table(name = "pms_spu_info")
public class SpuInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 商品名称
	 */
	@Column(columnDefinition = "varchar(200)")
	private String spuName;
	/**
	 * 商品描述
	 */
	@Column(columnDefinition = "varchar(1000)")
	private String spuDescription;
	/**
	 * 所属分类id
	 */
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id", referencedColumnName = "id")
	@JsonBackReference
	private CategoryDO category;

	/**
	 * 品牌id
	 */
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id",referencedColumnName = "id")
	@JsonBackReference
	private BrandDO brand;

	/**
	 * 商品描述
	 */
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.LAZY)
	@JoinColumn(name = "info_id",referencedColumnName = "id")
	@JsonManagedReference
	private SpuInfoDescDO spuInfoDesc;

	/**
	 * 商品图片
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "spuInfo",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SpuImagesDO> spuImages;

	/**
	 * 商品评价
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "spuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SpuCommentDO> spuComments;

	/**
	 * 商品sku
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "spuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SkuInfoDO> skuInfos;

	/**
	 * spu销售属性
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "spuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<ProductAttrValueDO> productAttrValues;

	/**
	 * 
	 */
	@Column(columnDefinition = "decimal(18,4)")
	private BigDecimal weight;
	/**
	 * 上架状态[0 - 下架，1 - 上架]
	 */
	@Column(columnDefinition = "tinyint")
	private Integer publishStatus;
	/**
	 * 
	 */
	@Column(columnDefinition = "datetime")
	private Date createTime;
	/**
	 * 
	 */
	@Column(columnDefinition = "datetime")
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpuName() {
		return spuName;
	}

	public void setSpuName(String spuName) {
		this.spuName = spuName;
	}

	public String getSpuDescription() {
		return spuDescription;
	}

	public void setSpuDescription(String spuDescription) {
		this.spuDescription = spuDescription;
	}

	public CategoryDO getCategory() {
		return category;
	}

	public void setCategory(CategoryDO category) {
		this.category = category;
	}

	public BrandDO getBrand() {
		return brand;
	}

	public void setBrand(BrandDO brand) {
		this.brand = brand;
	}

	public SpuInfoDescDO getSpuInfoDesc() {
		return spuInfoDesc;
	}

	public void setSpuInfoDesc(SpuInfoDescDO spuInfoDesc) {
		this.spuInfoDesc = spuInfoDesc;
	}

	public Set<SpuImagesDO> getSpuImages() {
		return spuImages;
	}

	public void setSpuImages(Set<SpuImagesDO> spuImages) {
		this.spuImages = spuImages;
	}

	public Set<SpuCommentDO> getSpuComments() {
		return spuComments;
	}

	public void setSpuComments(Set<SpuCommentDO> spuComments) {
		this.spuComments = spuComments;
	}

	public Set<SkuInfoDO> getSkuInfos() {
		return skuInfos;
	}

	public void setSkuInfos(Set<SkuInfoDO> skuInfos) {
		this.skuInfos = skuInfos;
	}

	public Set<ProductAttrValueDO> getProductAttrValues() {
		return productAttrValues;
	}

	public void setProductAttrValues(Set<ProductAttrValueDO> productAttrValues) {
		this.productAttrValues = productAttrValues;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
