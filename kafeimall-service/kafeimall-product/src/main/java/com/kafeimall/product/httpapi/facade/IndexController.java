package com.kafeimall.product.httpapi.facade;

import com.kafeimall.common.result.Result;
import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.dto.CatalogDto;
import com.kafeimall.product.application.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private CategoryApplicationService categoryService;

    /**
     * 获取分类树
     * @return 分类树信息
     */
    @GetMapping("/list/tree")
    public Result<List<CategoryDto>> getCategory(){
        return Result.success(categoryService.getCategory());
    }

    /**
     * 修改排序
     * @param categoryDto 修改分类平排序入参
     */
    @PostMapping("/update/sort")
    public Result<Object> updateCategorySort(CategoryDto categoryDto){
        categoryService.updateCategoryById(categoryDto);
        return Result.ok();
    }

    /**
     * 获取分类列表
     * @return 分类列表信息
     */
    @PostMapping("/category/getCatalog")
    public Result<List<CatalogDto>> getCatalog() {
        List<CatalogDto> catalogDtos = categoryService.getCatalog();
        return Result.success(catalogDtos);
    }
}
