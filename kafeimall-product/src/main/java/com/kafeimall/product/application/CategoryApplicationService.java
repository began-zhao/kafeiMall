package com.kafeimall.product.application;

import com.kafeimall.product.application.dto.CategoryDTO;

import java.util.List;

public interface CategoryApplicationService {
    /*获取商品分类树形图*/
    List<CategoryDTO> getCategory();
}
