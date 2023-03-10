package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author: zzg
 * @date: 8/30/22
 * @Description: zzg
 */
@Table(name="pms_attr_group")
public class AttrGroupDO implements Serializable {
    private static final long serialVersionUID = -2012878767259390658L;

    /**
     * 分组id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attrGroupId;
    /**
     * 组名
     */
    @Column(columnDefinition = "char(20)")
    private String attrGroupName;
    /**
     * 排序
     */
    @Column(columnDefinition = "int")
    private Integer sort;
    /**
     * 描述
     */
    @Column(columnDefinition = "varchar(255)")
    private String descript;
    /**
     * 组图标
     */
    @Column(columnDefinition = "varchar(255)")
    private String icon;
    /**
     * 所属分类id
     */
    @Column(columnDefinition = "bigint")
    private Long catelogId;

    @JsonBackReference
    @ManyToMany(mappedBy = "attrGroups",cascade = CascadeType.DETACH)
    private Set<AttrDO> attrs;

    @Transient
    private Long[] catelogPath;

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public String getAttrGroupName() {
        return attrGroupName;
    }

    public void setAttrGroupName(String attrGroupName) {
        this.attrGroupName = attrGroupName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    public Set<AttrDO> getAttrs() {
        return attrs;
    }

    public void setAttrs(Set<AttrDO> attrs) {
        this.attrs = attrs;
    }

    public Long[] getCatelogPath() {
        return catelogPath;
    }

    public void setCatelogPath(Long[] catelogPath) {
        this.catelogPath = catelogPath;
    }
}
