package com.kafeimall.product.service.impl;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.repo.repository.CategoryRepository;
import com.kafeimall.product.service.CategoryService;
import com.kafeimall.product.service.converter.CategoryConverter;
import com.kafeimall.product.service.dto.CategoryDTO;
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
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public List<CategoryDTO> getCategory() {
        List<ProductCategory> productCategory = categoryRepository.getProductCategory();
        List<CategoryDTO> categoryDTOS = productCategory.stream().map(e -> {
            e.setChildren(getChildren(e, productCategory));
            return CategoryConverter.INSTANCE.toCategoryDTO(e);
        }).collect(Collectors.toList());
        return categoryDTOS;
    }

    //递归获取分类子节点
    public List<ProductCategory> getChildren(ProductCategory root, List<ProductCategory> all) {
        List<ProductCategory> categoryPOS = all.stream().filter(t -> {
                    return t.getParentCid().equals(root.getCatId());
                })
                .map(f -> {
                    f.setChildren(getChildren(f, all));
                    return f;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

        return categoryPOS;
    }
}