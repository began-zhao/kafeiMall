package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.infrastructure.repo.dao.CategoryDao;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPo;
import com.kafeimall.product.infrastructure.repo.repository.CategoryRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.CategoryRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 8/26/22
 * @Description: zzg
 */
@Service("CategoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryRepositoryConverter categoryConverter;

    //资源层访问数据库获取分类数据（仅对聚合根进行资源管理）
    @Override
    public List<CategoryAggregate> getProductCategory() {
        List<CategoryPo> categoryPOS = categoryDao.selectList(null);
        List<CategoryAggregate> productCategories = categoryPOS.stream().map(e -> {
            CategoryAggregate productCategory =categoryConverter.toProductCategoryDO(e);
            return productCategory;
        }).collect(Collectors.toList());
        return productCategories;
    }

    @Override
    public void updateCategoryById(CategoryAggregate categoryDO) {
        CategoryPo categoryPO = categoryConverter.toProductCategoryPO(categoryDO);
        int updateById = categoryDao.updateById(categoryPO);
    }
}
