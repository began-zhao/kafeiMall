package com.kafeimall.product.domain.aggregate;

import com.kafeimall.common.domain.AggregateRoot;
import com.kafeimall.product.domain.valobj.Attr;
import com.kafeimall.product.domain.valobj.SpuComment;
import com.kafeimall.product.domain.valobj.SpuImage;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    /**
     * Spu图片
    * */
    private List<SpuImage> spuImages;

    /**
     * Spu详情
     * */
    private SpuInfoDesc spuInfoDesc;

    /**
     * Spu评价
     * */
    private List<SpuComment> spuComments;
    /**
     * Spu 属性
     * */
    private Attr spuAttr;

}
