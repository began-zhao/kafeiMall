package com.kafeimall.product.domain.model;

import com.kafeimall.common.domain.AggregateRoot;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zzg
 * @date: 8/30/22
 * @Description: Spu管理聚合根
 */
@Data
@NoArgsConstructor
public class SpuAggregate extends AggregateRoot {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String spuName;
    /**
     * 商品描述
     */
    private String spuDescription;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     *
     */
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

//    /**
//     * Spu图片
//    * */
//    private List<SpuImage> spuImages;
//
//    /**
//     * Spu详情
//     * */
//    private SpuInfoDesc spuInfoDesc;
//
//    /**
//     * Spu评价
//     * */
//    private List<SpuComment> spuComments;
//    /**
//     * Spu 属性
//     * */
//    private Attr spuAttr;
//    /**
//     * 销售属性组合信息
//     * */
//    private List<SkuItemSaleAttr> skuItemSaleAttrs;
//
//    /**
//     * 规格参数信息
//     * */
//    private List<SpuItemAttrGroup> spuItemAttrGroups;

}
