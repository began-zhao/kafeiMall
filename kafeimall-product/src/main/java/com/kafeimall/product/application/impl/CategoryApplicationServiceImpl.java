package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.service.CategoryDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    @Autowired
    CategoryDomainService categoryDomainService;

    public List<CategoryDTO> getCategory(){
        return categoryDomainService.getCategory();
    }
    @Override
    public void updateCategoryById(CategoryDTO categoryDTO) {
        categoryDomainService.updateCategoryById(categoryDTO);
    }
}
