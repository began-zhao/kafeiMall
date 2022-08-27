package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: CategoryPO-DO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryRepositoryConverter {
   ProductCategory toProductCategoryDO(CategoryPO categoryPO);
}
