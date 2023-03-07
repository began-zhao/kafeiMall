package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * spu图片
 *
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:46
 */
@Table(name = "pms_spu_images")
public class SpuImagesDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * spu_id
     */
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "spu_id", referencedColumnName = "id")
    private SpuInfoDO spuInfo;
    /**
     * 图片名
     */
    @Column(columnDefinition = "varchar(200)")
    private String imgName;
    /**
     * 图片地址
     */
    @Column(columnDefinition = "varchar(255)")
    private String imgUrl;
    /**
     * 顺序
     */
    @Column(columnDefinition = "int")
    private Integer imgSort;
    /**
     * 是否默认图
     */
    @Column(columnDefinition = "tinyint")
    private Integer defaultImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpuInfoDO getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(SpuInfoDO spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgSort() {
        return imgSort;
    }

    public void setImgSort(Integer imgSort) {
        this.imgSort = imgSort;
    }

    public Integer getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(Integer defaultImg) {
        this.defaultImg = defaultImg;
    }
}
