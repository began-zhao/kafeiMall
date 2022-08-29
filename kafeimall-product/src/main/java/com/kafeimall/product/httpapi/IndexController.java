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
        System.out.println("查询了数据库。。。。");
        List<CategoryDTO> category = categoryService.getCategory();
        CatelogVo catelogVo=null;
        List<CatelogVo> collect = category.stream().map(v -> {
            List<CategoryDTO> categoryEntities1 = v.getChildren();

            List<CatelogVo.Catalog2Vo> catelog2Vos = null;
            if (categoryEntities1 != null) {
                catelog2Vos = categoryEntities1.stream().map(l2 -> {
                    CatelogVo.Catalog2Vo catelog2 = new CatelogVo.Catalog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryDTO> level3Catelog = l2.getChildren();

                    if (level3Catelog != null) {
                        List<CatelogVo.Catalog3Vo> catelog3Vos = level3Catelog.stream().map(l3 -> {
                            CatelogVo.Catalog3Vo catelog3Vo = new CatelogVo.Catalog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return catelog3Vo;
                        }).collect(Collectors.toList());
                        catelog2.setCatalog3List(catelog3Vos);
                    }

                    return catelog2;
                }).collect(Collectors.toList());
            }
            catelogVo.setCatalog2List(catelog2Vos);
            return catelogVo;
        }).collect(Collectors.toList());
        return collect;
    }
}
