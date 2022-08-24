package com.kafeimall.product.application;

import com.kafeimall.product.service.CategoryService;
import com.kafeimall.product.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/test")
    public List<CategoryDTO> getCategory(){
        List<CategoryDTO> category = categoryService.getCategory();
        return category;
    }
}
