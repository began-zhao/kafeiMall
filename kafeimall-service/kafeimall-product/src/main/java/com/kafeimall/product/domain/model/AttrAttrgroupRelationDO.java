package com.kafeimall.product.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 属性&属性分组关联
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:46
 */
@Table(name = "pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationDO implements Serializable {
	private static final long serialVersionUID = -407938942319000635L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 属性id
	 */
	@Column(columnDefinition = "bigint")
	private Long attrId;
	/**
	 * 属性分组id
	 */
	@Column(columnDefinition = "bigint")
	private Long attrGroupId;
	/**
	 * 属性组内排序
	 */
	@Column(columnDefinition = "int")
	private Integer attrSort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public Long getAttrGroupId() {
		return attrGroupId;
	}

	public void setAttrGroupId(Long attrGroupId) {
		this.attrGroupId = attrGroupId;
	}

	public Integer getAttrSort() {
		return attrSort;
	}

	public void setAttrSort(Integer attrSort) {
		this.attrSort = attrSort;
	}
}
