package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.converter.CategoryServiceConverter;
import com.kafeimall.product.application.dto.CatalogDTO;
import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.service.ProductDomainQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    @Autowired
    ProductDomainQueryService categoryDomainQueryService;
    @Autowired
    CategoryServiceConverter categoryServiceConverter;


    public List<CategoryDTO> getCategory(){
        List<CategoryAggregate> productCategory = categoryDomainQueryService.getCategory();
            List<CategoryDTO> categoryDTOS = productCategory.stream().map(e -> {
            CategoryDTO categoryDTO = categoryServiceConverter.toCategoryDTO(e);
            categoryDTO.setChildren(getChildren(e, productCategory));
            return categoryDTO;
        }).collect(Collectors.toList());
        return categoryDTOS;
    }
    @Override
    public void updateCategoryById(CategoryDTO categoryDTO) {
        CategoryAggregate categoryAggregate = categoryServiceConverter.toCategoryDO(categoryDTO);
        categoryDomainQueryService.updateCategoryById(categoryAggregate);
    }

    @Override
    @Cacheable(value = {"category"},key = "#root.methodName")
    public List<CatalogDTO> getCatalog() {
        System.out.println("查询了数据库。。。。");
        List<CategoryDTO> category = getCategory();
        CatalogDTO catalogDTO=null;
        List<CatalogDTO> collect = category.stream().map(v -> {
            List<CategoryDTO> categoryEntities1 = v.getChildren();

            List<CatalogDTO.Catalog2DTO> catalog2DTOs = null;
            if (categoryEntities1 != null) {
                catalog2DTOs = categoryEntities1.stream().map(l2 -> {
                    CatalogDTO.Catalog2DTO catelog2 = new CatalogDTO.Catalog2DTO(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryDTO> level3Catalog = l2.getChildren();

                    if (level3Catalog != null) {
                        List<CatalogDTO.Catalog3DTO> catalog3DTOs = level3Catalog.stream().map(l3 -> {
                            CatalogDTO.Catalog3DTO catalog3DTO = new CatalogDTO.Catalog3DTO(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return catalog3DTO;
                        }).collect(Collectors.toList());
                        catelog2.setCatalog3List(catalog3DTOs);
                    }

                    return catelog2;
                }).collect(Collectors.toList());
            }
            catalogDTO.setCatalog2List(catalog2DTOs);
            return catalogDTO;
        }).collect(Collectors.toList());

        return collect;
    }

    //递归获取分类子节点
    public List<CategoryDTO> getChildren(CategoryAggregate root, List<CategoryAggregate> all) {
        List<CategoryDTO> categoryDTOS = all.stream().filter(t -> {
                    return t.getParentCid().equals(root.getCatId());
                })
                .map(f -> {
                    CategoryDTO categoryDTO = categoryServiceConverter.toCategoryDTO(f);
                    categoryDTO .setChildren(getChildren(f, all));
                    return categoryDTO;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

        return categoryDTOS;
    }
}
