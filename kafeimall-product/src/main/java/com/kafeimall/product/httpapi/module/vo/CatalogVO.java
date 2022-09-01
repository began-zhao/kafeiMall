package com.kafeimall.product.httpapi.module.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/29/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogVO {
    private String id;
    private String name;
    private List<Catalog2VO> catalog2List;//二级子分类

    /**
     * 二级分类vo
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Catalog2VO{
        private String catalog1Id;//1级父分类id
        private List<Catalog3VO> catalog3List;//三级子分类
        private String id;
        private  String name;
    }
    /**
     * 三级分类vo
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class  Catalog3VO{
        private String catalog2Id;//父分类，2级分类ID
        private String id;
        private String name;
    }
}