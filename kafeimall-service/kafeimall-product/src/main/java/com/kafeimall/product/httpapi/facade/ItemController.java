package com.kafeimall.product.httpapi.facade;

import com.kafeimall.common.result.Result;
import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.application.dto.SkuItemDto;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ItemController {

    @Autowired
    SkuApplicationService skuApplicationService;

    /**
     * 展示当前sku的详情
     *
     * @param skuId
     * @return 当前展示的sku详情
     */
    @GetMapping("/{skuId}")
    public Result<SkuItemDto> skuItem(@PathVariable("skuId") Long skuId) throws ExecutionException, InterruptedException {

        SkuItemDto item = skuApplicationService.getItem(skuId);
        log.info("准备查询" + skuId + "详情");
        return Result.success(item);
    }
}
