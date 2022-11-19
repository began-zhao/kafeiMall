package com.kafeimall.product.httpapi.controller;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.httpapi.converter.SkuAPIConverter;
import com.kafeimall.product.httpapi.module.response.SkuItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 8/25/22
 * @Description: 品牌应用层
 */
@RestController
@RequestMapping("product/sku")
public class ItemController {

    @Autowired
    SkuApplicationService skuApplicationService;

    @Autowired
    SkuAPIConverter skuApIConverter;
    /**
     * 展示当前sku的详情
     * @param skuId
     * @return
     */
    @GetMapping("/{skuId}")
    public SkuItemResponse skuItem(@PathVariable("skuId") Long skuId) throws ExecutionException, InterruptedException {

        SkuItemDTO item = skuApplicationService.getItem(skuId);
        System.out.println("准备查询"+skuId+"详情");
        SkuItemResponse skuItemResponse = skuApIConverter.toSkuItemVO(item);
        return skuItemResponse;
    }
}
