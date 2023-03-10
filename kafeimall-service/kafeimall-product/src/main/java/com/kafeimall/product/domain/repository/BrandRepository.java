package com.kafeimall.product.domain.repository;

import com.kafeimall.product.domain.model.BrandDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 品牌资源层
 */
@Repository
public interface BrandRepository extends JpaRepository<BrandDO,Long>, JpaSpecificationExecutor<BrandDO> {

}
