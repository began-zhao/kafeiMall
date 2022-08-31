package com.kafeimall.product.service;


import com.kafeimall.product.domain.aggregate.CategoryAggregate;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
public interface ProductDomainQueryService {
    List<CategoryAggregate> getCategory();
    void updateCategoryById(CategoryAggregate categoryAggregate);

}
