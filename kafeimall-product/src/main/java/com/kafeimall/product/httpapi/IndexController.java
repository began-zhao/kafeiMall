package com.kafeimall.product.httpapi;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.dto.CatalogDTO;
import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.httpapi.converter.CatalogAPIConverter;
import com.kafeimall.product.httpapi.converter.CategoryAPIConverter;
import com.kafeimall.product.httpapi.module.req.CategoryUpdateSortReq;
import com.kafeimall.product.httpapi.module.vo.CatalogVO;
import com.kafeimall.product.httpapi.module.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private CategoryAPIConverter categoryAPIConverter;
    @Autowired
    private CatalogAPIConverter catelogAPIConverter;

    @GetMapping("/list/tree")
    public List<CategoryVO> getCategory(){
        List<CategoryDTO> category = categoryService.getCategory();
        List<CategoryVO> collect = category.stream().map(e -> {
            return categoryAPIConverter.toCategoryVO(e);
        }).collect(Collectors.toList());
        return collect;
    }

    @PostMapping("/update/sort")
    public void updateCategorySort(CategoryUpdateSortReq categoryReq){
        CategoryDTO categoryDTO = categoryAPIConverter.toCategoryDTO(categoryReq);
        categoryService.updateCategoryById(categoryDTO);
    }
    @PostMapping("/category/getCatalog")
    public List<CatalogVO> getCatalog() {
        List<CatalogDTO> catalogDTOS = categoryService.getCatalog();
        List<CatalogVO> collect = catalogDTOS.stream().map(e -> {
            return catelogAPIConverter.toCatalogVO(e);
        }).collect(Collectors.toList());
        return collect;
    }
}
