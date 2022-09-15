package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kafeimall.product.infrastructure.repo.dao.BrandDao;
import com.kafeimall.product.infrastructure.repo.dao.po.BrandPO;
import com.kafeimall.product.infrastructure.repo.repository.BrandRepository;
import org.springframework.stereotype.Service;

/**
 * @author: zzg
 * @date: 8/26/22
 * @Description: zzg
 */
@Service("BrandRepository")
public class BrandRepositoryImpl extends ServiceImpl<BrandDao, BrandPO> implements BrandRepository {
}
