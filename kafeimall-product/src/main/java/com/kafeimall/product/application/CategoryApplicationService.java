package com.kafeimall.product.application;

import com.kafeimall.product.application.dto.CatalogDTO;
import com.kafeimall.product.application.dto.CategoryDTO;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: Category应用层
 */
public interface CategoryApplicationService {
    /*获取商品分类树形图*/
    List<CategoryDTO> getCategory();

    void updateCategoryById(CategoryDTO categoryDTO);

    List<CatalogDTO> getCatalog();

}
