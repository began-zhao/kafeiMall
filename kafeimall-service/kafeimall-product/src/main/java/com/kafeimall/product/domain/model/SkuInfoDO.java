package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * sku信息
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Table(name = "pms_sku_info")
public class SkuInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * skuId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skuId;

	/**
	 * spuId
	 */
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "spu_id", referencedColumnName = "id")
	@JsonBackReference
	private SpuInfoDO spuInfo;
	/**
	 * sku名称
	 */
	@Column(columnDefinition = "varchar(255)")
	private String skuName;
	/**
	 * sku介绍描述
	 */
	@Column(columnDefinition = "varchar(2000)")
	private String skuDesc;
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
	 * 默认图片
	 */
	@Column(columnDefinition = "varchar(255)")
	private String skuDefaultImg;
	/**
	 * 标题
	 */
	@Column(columnDefinition = "varchar(255)")
	private String skuTitle;
	/**
	 * 副标题
	 */
	@Column(columnDefinition = "varchar(2000)")
	private String skuSubtitle;
	/**
	 * 价格
	 */
	@Column(columnDefinition = "decimal(18,4)")
	private BigDecimal price;
	/**
	 * 销量
	 */
	@Column(columnDefinition = "bigint")
	private Long saleCount;

	/**
	 * 商品评价
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "skuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SpuCommentDO> spuComments;

	/**
	 * sku销售属性
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "skuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SkuSaleAttrValueDO> skuSaleAttrValues;

	/**
	 * sku图片
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "skuInfo",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Set<SkuImagesDO> skuImages;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public SpuInfoDO getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(SpuInfoDO spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuDesc() {
		return skuDesc;
	}

	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
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

	public String getSkuDefaultImg() {
		return skuDefaultImg;
	}

	public void setSkuDefaultImg(String skuDefaultImg) {
		this.skuDefaultImg = skuDefaultImg;
	}

	public String getSkuTitle() {
		return skuTitle;
	}

	public void setSkuTitle(String skuTitle) {
		this.skuTitle = skuTitle;
	}

	public String getSkuSubtitle() {
		return skuSubtitle;
	}

	public void setSkuSubtitle(String skuSubtitle) {
		this.skuSubtitle = skuSubtitle;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Long saleCount) {
		this.saleCount = saleCount;
	}

	public Set<SpuCommentDO> getSpuComments() {
		return spuComments;
	}

	public void setSpuComments(Set<SpuCommentDO> spuComments) {
		this.spuComments = spuComments;
	}

	public Set<SkuSaleAttrValueDO> getSkuSaleAttrValues() {
		return skuSaleAttrValues;
	}

	public void setSkuSaleAttrValues(Set<SkuSaleAttrValueDO> skuSaleAttrValues) {
		this.skuSaleAttrValues = skuSaleAttrValues;
	}

	public Set<SkuImagesDO> getSkuImages() {
		return skuImages;
	}

	public void setSkuImages(Set<SkuImagesDO> skuImages) {
		this.skuImages = skuImages;
	}
}
