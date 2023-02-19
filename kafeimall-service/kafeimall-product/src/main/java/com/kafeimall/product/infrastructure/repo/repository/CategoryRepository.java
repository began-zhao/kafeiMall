package com.kafeimall.product.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: 分类资源层
 */

public interface CategoryRepository extends IRepository<CategoryAggregate>  {

    //资源层访问数据库获取分类数据（仅对聚合根进行资源管理）
    List<CategoryAggregate> getProductCategory();

    void updateCategoryById(CategoryAggregate categoryDO);
}
