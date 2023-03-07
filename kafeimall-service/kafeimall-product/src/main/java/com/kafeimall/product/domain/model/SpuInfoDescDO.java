package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * spu信息介绍
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:46
 */
@Table(name = "pms_spu_info_desc")
public class SpuInfoDescDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商品id
	 */
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH},fetch = FetchType.LAZY)
	@JoinColumn(name = "spu_id",referencedColumnName = "id")
	@JsonBackReference
	private SpuInfoDO spuInfo;
	/**
	 * 商品介绍
	 */
	@Column(columnDefinition = "longtext")
	private String decript;

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

	public String getDecript() {
		return decript;
	}

	public void setDecript(String decript) {
		this.decript = decript;
	}
}
