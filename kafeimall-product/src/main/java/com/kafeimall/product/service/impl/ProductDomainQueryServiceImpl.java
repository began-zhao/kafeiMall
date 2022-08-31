package com.kafeimall.product.service.impl;

import com.kafeimall.product.application.converter.CategoryServiceConverter;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.infrastructure.repo.repository.CategoryRepository;
import com.kafeimall.product.service.ProductDomainQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
@Service
public class ProductDomainQueryServiceImpl implements ProductDomainQueryService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceConverter categoryConverter;


    @Override
    public List<CategoryAggregate> getCategory() {
        List<CategoryAggregate> productCategory = categoryRepository.getProductCategory();
        return productCategory;
    }

    @Override
    public void updateCategoryById(CategoryAggregate categoryAggregate) {
        categoryRepository.updateCategoryById(categoryAggregate);
    }

}