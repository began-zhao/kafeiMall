package com.kafeimall.product.domain.aggregate;

import com.kafeimall.common.domain.AggregateRoot;
import com.kafeimall.product.domain.valobj.Attr;
import com.kafeimall.product.domain.valobj.SkuImage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: zzg
 * @date: 8/30/22
 * @Description: sku管理聚合根
 */
@Data
@NoArgsConstructor
public class SkuAggregate extends AggregateRoot {
    /**
     * skuId
     */
    private Long skuId;
    /**
     * spuId
     */
    private Long spuId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * sku介绍描述
     */
    private String skuDesc;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 默认图片
     */
    private String skuDefaultImg;
    /**
     * 标题
     */
    private String skuTitle;
    /**
     * 副标题
     */
    private String skuSubtitle;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 销量
     */
    private Long saleCount;

    /**
     * SKU属性
     * */
    private Attr attr;
    /**
     * SKU图片
     * */
    private List<SkuImage> skuImages;
}
