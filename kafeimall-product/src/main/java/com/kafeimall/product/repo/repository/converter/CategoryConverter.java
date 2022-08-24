package com.kafeimall.product.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.repo.dao.po.CategoryPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: CategoryPO-DO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryConverter {
   CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

   ProductCategory toProductCategoryDO(CategoryPO categoryPO);
}
