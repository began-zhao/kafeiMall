package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: CategoryPO-DO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryRepositoryConverter {
   CategoryAggregate toProductCategoryDO(CategoryPO categoryPO);

   CategoryPO toProductCategoryPO(CategoryAggregate categoryDO);

}
