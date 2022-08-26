package com.kafeimall.product.repo.repository.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.repo.dao.CategoryDao;
import com.kafeimall.product.repo.dao.po.CategoryPO;
import com.kafeimall.product.repo.repository.CategoryRepository;
import com.kafeimall.product.repo.repository.converter.CategoryRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 8/26/22
 * @Description: zzg
 */
public class CategoryRepositoryImpl  extends ServiceImpl<CategoryDao, CategoryPO> implements CategoryRepository {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryRepositoryConverter categoryConverter;

    //资源层访问数据库获取分类数据（仅对聚合根进行资源管理）
    @Override
    public List<ProductCategory> getProductCategory() {
        List<CategoryPO> categoryPOS = categoryDao.selectList(null);
        List<ProductCategory> productCategories = categoryPOS.stream().map(e -> {
            ProductCategory productCategory =categoryConverter.toProductCategoryDO(e);
            return productCategory;
        }).collect(Collectors.toList());
        return productCategories;
    }
}
