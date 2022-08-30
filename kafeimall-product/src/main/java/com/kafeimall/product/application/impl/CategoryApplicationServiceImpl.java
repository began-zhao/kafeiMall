package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.httpapi.module.vo.CatelogVo;
import com.kafeimall.product.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    @Autowired
    ProductDomainService categoryDomainService;

    public List<CategoryDTO> getCategory(){
        return categoryDomainService.getCategory();
    }
    @Override
    public void updateCategoryById(CategoryDTO categoryDTO) {
        categoryDomainService.updateCategoryById(categoryDTO);
    }

    @Override
    @Cacheable(value = {"category"},key = "#root.methodName")
    public List<CatelogVo> getCatalog() {
        System.out.println("查询了数据库。。。。");
        List<CategoryDTO> category = categoryDomainService.getCategory();
        CatelogVo catelogVo=null;
        List<CatelogVo> collect = category.stream().map(v -> {
            List<CategoryDTO> categoryEntities1 = v.getChildren();

            List<CatelogVo.Catalog2Vo> catelog2Vos = null;
            if (categoryEntities1 != null) {
                catelog2Vos = categoryEntities1.stream().map(l2 -> {
                    CatelogVo.Catalog2Vo catelog2 = new CatelogVo.Catalog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryDTO> level3Catelog = l2.getChildren();

                    if (level3Catelog != null) {
                        List<CatelogVo.Catalog3Vo> catelog3Vos = level3Catelog.stream().map(l3 -> {
                            CatelogVo.Catalog3Vo catelog3Vo = new CatelogVo.Catalog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return catelog3Vo;
                        }).collect(Collectors.toList());
                        catelog2.setCatalog3List(catelog3Vos);
                    }

                    return catelog2;
                }).collect(Collectors.toList());
            }
            catelogVo.setCatalog2List(catelog2Vos);
            return catelogVo;
        }).collect(Collectors.toList());
        return collect;
    }

}
