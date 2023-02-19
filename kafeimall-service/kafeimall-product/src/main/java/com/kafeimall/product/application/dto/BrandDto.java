package com.kafeimall.product.application.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.kafeimall.common.valid.AddGroup;
import com.kafeimall.common.valid.ListValue;
import com.kafeimall.common.valid.UpdateGroup;
import com.kafeimall.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * @author: zzg
 * @date: 8/25/22
 * @Description: 品牌DTO
 */
@Data
public class BrandDto {
    /**
     * 品牌id
     */
    @NotNull(message = "修改必须指定品牌ID",groups = {UpdateGroup.class})
    @Null(message = "新增不能指定ID",groups = {AddGroup.class})
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
    @NotBlank(groups = {AddGroup.class})
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
    @ListValue(message = "必须提交指定的值",vals = {0,1},groups = {AddGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @NotEmpty(groups = {AddGroup.class})
    @Pattern(regexp = "^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups = {AddGroup.class,UpdateGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @NotNull(groups = {AddGroup.class})
    @Min(value = 0,message = "排序必须大于等于0",groups = {AddGroup.class,UpdateGroup.class})
    private Integer sort;
}
