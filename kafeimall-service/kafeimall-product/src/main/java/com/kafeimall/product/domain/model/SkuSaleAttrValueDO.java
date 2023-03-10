package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * sku销售属性&值
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Table(name="pms_sku_sale_attr_value")
public class SkuSaleAttrValueDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * sku_id
	 */
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "sku_id",referencedColumnName = "id")
	@JsonBackReference
	private SkuInfoDO skuInfo;
	/**
	 * attr_id
	 */
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "attr_id",referencedColumnName = "id")
	@JsonBackReference
	private AttrDO attr;
	/**
	 * 销售属性名
	 */
	@Column(columnDefinition = "varchar(200)")
	private String attrName;
	/**
	 * 销售属性值
	 */
	@Column(columnDefinition = "varchar(200)")
	private String attrValue;
	/**
	 * 顺序
	 */
	@Column(columnDefinition = "int")
	private Integer attrSort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SkuInfoDO getSkuInfo() {
		return skuInfo;
	}

	public void setSkuInfo(SkuInfoDO skuInfo) {
		this.skuInfo = skuInfo;
	}

	public AttrDO getAttr() {
		return attr;
	}

	public void setAttr(AttrDO attr) {
		this.attr = attr;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public Integer getAttrSort() {
		return attrSort;
	}

	public void setAttrSort(Integer attrSort) {
		this.attrSort = attrSort;
	}
}
