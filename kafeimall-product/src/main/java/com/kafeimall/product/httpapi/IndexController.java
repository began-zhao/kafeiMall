package com.kafeimall.product.httpapi;

import com.kafeimall.product.application.CategoryApplicationService;
import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.httpapi.converter.CategoryAPIConverter;
import com.kafeimall.product.httpapi.module.req.CategoryUpdateSortReq;
import com.kafeimall.product.httpapi.module.vo.CategoryVO;
import com.kafeimall.product.httpapi.module.vo.CatelogVo;
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

    public List<CatelogVo> getCatalog() {
        return categoryService.getCatalog();
    }
}
