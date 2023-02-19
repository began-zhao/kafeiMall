package com.kafeimall.search.controller;

import com.kafeimall.common.exception.BizCodeEnum;
import com.kafeimall.common.result.Result;
import com.kafeimall.search.model.SkuEsModel;
import com.kafeimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zzg
 * @date: 2022/12/1
 * @Description: zzg
 */
@RequestMapping("/search/save")
@RestController
@Slf4j
public class ElasticSaveController {

    @Resource
    ProductSaveService productSaveService;

    //上架商品
    @PostMapping("/product")
    public Result productStatusUp(@RequestBody List<SkuEsModel> skuEsModelList) {
        boolean b = false;
        try {
            b = productSaveService.productStatusUp(skuEsModelList);

        } catch (Exception e) {
            log.error("ElasticSaveController商品上架错误：{}", e);
            return Result.error(String.valueOf(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode()), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }
        if (!b) {
            return Result.ok();
        } else {
            return Result.error(String.valueOf(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode()), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }
    }
}
