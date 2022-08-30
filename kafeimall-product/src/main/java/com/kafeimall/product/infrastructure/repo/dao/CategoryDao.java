package com.kafeimall.product.infrastructure.repo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: zzg
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryPo> {
}
