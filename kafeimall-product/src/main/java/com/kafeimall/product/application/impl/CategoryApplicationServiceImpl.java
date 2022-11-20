package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.converter.CategoryServiceConverter;
import com.kafeimall.product.application.dto.CatalogDto;
import com.kafeimall.product.application.dto.CategoryDto;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    @Autowired
    ProductDomainService categoryDomainQueryService;
    @Autowired
    CategoryServiceConverter categoryServiceConverter;


    public List<CategoryDto> getCategory(){
        List<CategoryAggregate> productCategory = categoryDomainQueryService.getCategory();
            List<CategoryDto> categoryDtos = productCategory.stream().map(e -> {
            CategoryDto categoryDTO = categoryServiceConverter.toCategoryDTO(e);
            categoryDTO.setChildren(getChildren(e, productCategory));
            return categoryDTO;
        }).collect(Collectors.toList());
        return categoryDtos;
    }
    @Override
    public void updateCategoryById(CategoryDto categoryDTO) {
        CategoryAggregate categoryAggregate = categoryServiceConverter.toCategoryDO(categoryDTO);
        categoryDomainQueryService.updateCategoryById(categoryAggregate);
    }

    @Override
    @Cacheable(value = {"category"},key = "#root.methodName")
    public List<CatalogDto> getCatalog() {
        System.out.println("查询了数据库。。。。");
        List<CategoryDto> category = getCategory();
        CatalogDto catalogDTO=null;
        List<CatalogDto> collect = category.stream().map(v -> {
            List<CategoryDto> categoryEntities1 = v.getChildren();

            List<CatalogDto.Catalog2DTO> catalog2DTOs = null;
            if (categoryEntities1 != null) {
                catalog2DTOs = categoryEntities1.stream().map(l2 -> {
                    CatalogDto.Catalog2DTO catelog2 = new CatalogDto.Catalog2DTO(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryDto> level3Catalog = l2.getChildren();

                    if (level3Catalog != null) {
                        List<CatalogDto.Catalog3DTO> catalog3DTOs = level3Catalog.stream().map(l3 -> {
                            CatalogDto.Catalog3DTO catalog3DTO = new CatalogDto.Catalog3DTO(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
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
    public List<CategoryDto> getChildren(CategoryAggregate root, List<CategoryAggregate> all) {
        List<CategoryDto> categoryDtos = all.stream().filter(t -> {
                    return t.getParentCid().equals(root.getCatId());
                })
                .map(f -> {
                    CategoryDto categoryDTO = categoryServiceConverter.toCategoryDTO(f);
                    categoryDTO .setChildren(getChildren(f, all));
                    return categoryDTO;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

        return categoryDtos;
    }
}
