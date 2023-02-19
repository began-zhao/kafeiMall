package com.kafeimall.product.domain.entity;

import com.kafeimall.common.domain.ValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: zzg
 */
@Data
@NoArgsConstructor
public class SpuImage extends ValueObject {
    /**
     * id
     */
    private Long id;
    /**
     * spu_id
     */
    private Long spuId;
    /**
     * 图片名
     */
    private String imgName;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 顺序
     */
    private Integer imgSort;
    /**
     * 是否默认图
     */
    private Integer defaultImg;
}
