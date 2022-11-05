package com.kafeimall.product.domain.entity;

import com.kafeimall.common.domain.ValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: zzg
 */
@Data
@NoArgsConstructor
public class SpuComment extends ValueObject {
    /**
     * id
     */
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * spu_id
     */
    private Long spuId;
    /**
     * 商品名字
     */
    private String spuName;
    /**
     * 会员昵称
     */
    private String memberNickName;
    /**
     * 星级
     */
    private Integer star;
    /**
     * 会员ip
     */
    private String memberIp;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 显示状态[0-不显示，1-显示]
     */
    private Integer showStatus;
    /**
     * 购买时属性组合
     */
    private String spuAttributes;
    /**
     * 点赞数
     */
    private Integer likesCount;
    /**
     * 回复数
     */
    private Integer replyCount;
    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    private String resources;
    /**
     * 内容
     */
    private String content;
    /**
     * 用户头像
     */
    private String memberIcon;
    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    private Integer commentType;
}
