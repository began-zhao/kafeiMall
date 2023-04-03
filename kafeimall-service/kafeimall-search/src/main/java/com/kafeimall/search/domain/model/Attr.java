package com.kafeimall.search.domain.model;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author: zzg
 * @date: 2023/3/11
 * @Description: 商品属性Mapping
 */
public class Attr {

    @Field(type = FieldType.Long)
    private Long attrId;

    /**
     * 属性名称
     */
    @Field(type = FieldType.Keyword)
    private String attrName;

    /**
     * 属性值
     */
    @Field(type = FieldType.Keyword)
    private String attrValue;

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
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
}
