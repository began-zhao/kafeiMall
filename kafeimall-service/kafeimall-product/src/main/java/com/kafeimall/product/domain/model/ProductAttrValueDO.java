package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * spu属性值
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Table(name = "pms_product_attr_value")
public class ProductAttrValueDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**商品id
	 */
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "spu_id",referencedColumnName = "id")
	@JsonBackReference
	private SpuInfoDO spuInfo;
	/**
	 * 属性id
	 */
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "attr_id",referencedColumnName = "id")
	@JsonBackReference
	private AttrDO attr;
	/**
	 * 属性名
	 */
	@Column(columnDefinition = "varchar(200)")
	private String attrName;
	/**
	 * 属性值
	 */
	@Column(columnDefinition = "varchar(200)")
	private String attrValue;
	/**
	 * 顺序
	 */
	@Column(columnDefinition = "int")
	private Integer attrSort;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】
	 */
	@Column(columnDefinition = "tinyint")
	private Integer quickShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SpuInfoDO getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(SpuInfoDO spuInfo) {
		this.spuInfo = spuInfo;
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

	public Integer getQuickShow() {
		return quickShow;
	}

	public void setQuickShow(Integer quickShow) {
		this.quickShow = quickShow;
	}
}
