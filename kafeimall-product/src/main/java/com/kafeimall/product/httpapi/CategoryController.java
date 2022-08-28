package com.kafeimall.product.httpapi;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.service.CategoryDomainService;
import com.kafeimall.product.application.dto.CategoryDTO;
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
public class CategoryController {
    @Autowired
    private CategoryApplicationService categoryService;

    @GetMapping("/list/tree")
    public List<CategoryDTO> getCategory(){
        List<CategoryDTO> category = categoryService.getCategory();
        return category;
    }

    @PostMapping("/update/sort")
    public void updateCategorySort(CategoryDTO categoryDTO){
//    categoryService

    }
}
