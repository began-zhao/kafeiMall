package com.kafeimall.product.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 品牌分类关联
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:47
 */
@Table(name = "pms_category_brand_relation")
public class CategoryBrandRelationDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 品牌id
	 */
	@Column(columnDefinition = "bigint")
	private Long brandId;
	/**
	 * 分类id
	 */
	@Column(columnDefinition = "bigint")
	private Long catelogId;
	/**
	 * 
	 */
	@Column(columnDefinition = "varchar(255)")
	private String brandName;
	/**
	 * 
	 */
	@Column(columnDefinition = "varchar(255)")
	private String catelogName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(Long catelogId) {
		this.catelogId = catelogId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCatelogName() {
		return catelogName;
	}

	public void setCatelogName(String catelogName) {
		this.catelogName = catelogName;
	}
}
