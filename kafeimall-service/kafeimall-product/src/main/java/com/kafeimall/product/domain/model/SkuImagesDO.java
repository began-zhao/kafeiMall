package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * sku图片
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Table(name = "pms_sku_images")
public class SkuImagesDO implements Serializable {
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
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
	@JoinColumn(name = "sku_id",referencedColumnName = "id")
	private SkuInfoDO skuInfo;
	/**
	 * 图片地址
	 */
	@Column(columnDefinition = "varchar(255)")
	private String imgUrl;
	/**
	 * 排序
	 */
	@Column(columnDefinition = "int")
	private Integer imgSort;
	/**
	 * 默认图[0 - 不是默认图，1 - 是默认图]
	 */
	@Column(columnDefinition = "int")
	private Integer defaultImg;

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getImgSort() {
		return imgSort;
	}

	public void setImgSort(Integer imgSort) {
		this.imgSort = imgSort;
	}

	public Integer getDefaultImg() {
		return defaultImg;
	}

	public void setDefaultImg(Integer defaultImg) {
		this.defaultImg = defaultImg;
	}
}
