package com.kafeimall.product.httpapi.controller;

import com.kafeimall.product.application.SkuApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
