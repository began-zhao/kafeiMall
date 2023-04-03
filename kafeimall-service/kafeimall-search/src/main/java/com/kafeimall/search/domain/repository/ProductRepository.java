package com.kafeimall.search.domain.repository;

import com.kafeimall.search.domain.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: zzg
 * @date: 2023/4/3
 * @Description: ES资源层
 */
public interface ProductRepository extends ElasticsearchRepository<Product,Long> {

}
