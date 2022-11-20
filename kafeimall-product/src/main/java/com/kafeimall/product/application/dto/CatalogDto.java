package com.kafeimall.product.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDto {
    private String id;
    private String name;
    private List<Catalog2DTO> catalog2List;//二级子分类

    /**
     * 二级分类vo
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Catalog2DTO{
        private String catalog1Id;//1级父分类id
        private List<Catalog3DTO> catalog3List;//三级子分类
        private String id;
        private  String name;
    }
    /**
     * 三级分类vo
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class  Catalog3DTO{
        private String catalog2Id;//父分类，2级分类ID
        private String id;
        private String name;
    }
}
