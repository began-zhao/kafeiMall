package com.kafeimall.product.service.impl;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.infrastructure.repo.repository.CategoryRepository;
import com.kafeimall.product.service.CategoryDomainService;
import com.kafeimall.product.application.converter.CategoryServiceConverter;
import com.kafeimall.product.application.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
@Service
public class CategoryDomainServiceImpl implements CategoryDomainService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceConverter categoryConverter;


    @Override
    public List<CategoryDTO> getCategory() {
        List<ProductCategory> productCategory = categoryRepository.getProductCategory();
        List<CategoryDTO> categoryDTOS = productCategory.stream().map(e -> {
            CategoryDTO categoryDTO = categoryConverter.toCategoryDTO(e);
            categoryDTO.setChildren(getChildren(e, productCategory));
            return categoryDTO;
        }).collect(Collectors.toList());
        return categoryDTOS;
    }


    //递归获取分类子节点
    public List<CategoryDTO> getChildren(ProductCategory root, List<ProductCategory> all) {
        List<CategoryDTO> categoryDTOS = all.stream().filter(t -> {
                    return t.getParentCid().equals(root.getCatId());
                })
                .map(f -> {
                    CategoryDTO categoryDTO = categoryConverter.toCategoryDTO(f);
                    categoryDTO .setChildren(getChildren(f, all));
                    return categoryDTO;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

        return categoryDTOS;
    }


    @Override
    public void updateCategoryById(CategoryDTO categoryDTO) {
        ProductCategory productCategory = categoryConverter.toCategoryDO(categoryDTO);
        categoryRepository.updateCategoryById(productCategory);
    }

}