package com.kafeimall.product.httpapi.controller;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.domain.model.BrandDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 分类应用层
 */
@RestController
@RequestMapping("product/category")
public class IndexController {
    @Autowired
    private SkuApplicationService applicationService;


    @GetMapping("brands")
    public List<BrandDO> testJPA(){
        return applicationService.getBrands();
    }


}
