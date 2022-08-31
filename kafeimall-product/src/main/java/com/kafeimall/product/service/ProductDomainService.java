package com.kafeimall.product.service;


import com.kafeimall.product.application.dto.CategoryDTO;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
public interface ProductDomainService {
    List<CategoryDTO> getCategory();
    void updateCategoryById(CategoryDTO categoryDTO);


}
