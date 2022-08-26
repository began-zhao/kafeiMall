package com.kafeimall.product.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.repo.dao.po.CategoryPO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: 分类资源层
 */
@Service
public interface CategoryRepository extends IRepository<CategoryPO> {
    //资源层访问数据库获取分类数据（仅对聚合根进行资源管理）
    public List<ProductCategory> getProductCategory();
}
