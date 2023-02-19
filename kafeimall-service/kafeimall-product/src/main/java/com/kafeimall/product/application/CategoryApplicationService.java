package com.kafeimall.product.application;

import com.kafeimall.product.application.dto.CatalogDto;
import com.kafeimall.product.application.dto.CategoryDto;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: Category应用层
 */
public interface CategoryApplicationService {
    /*获取商品分类树形图*/
    List<CategoryDto> getCategory();

    void updateCategoryById(CategoryDto categoryDTO);

    List<CatalogDto> getCatalog();

}
