package com.kafeimall.search.service;

import com.kafeimall.search.model.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author: zzg
 * @date: 2022/12/4
 * @Description: zzg
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModelList) throws IOException;
}
