package com.kafeimall.product.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品评价
 *
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-07 14:44:46
 */
@Table(name = "pms_spu_comment")
public class SpuCommentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * sku_id
     */
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id", referencedColumnName = "id")
    private SkuInfoDO skuInfo;

    /**
     * spu_id
     */
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "spu_id", referencedColumnName = "id")
    private SpuInfoDO spuInfo;

    /**
     * 商品名字
     */
    @Column(columnDefinition = "varchar(255)")
    private String spuName;

    /**
     * 会员昵称
     */
    @Column(columnDefinition = "varchar(255)")
    private String memberNickName;
    /**
     * 星级
     */
    @Column(columnDefinition = "tinyint(1)")
    private Integer star;
    /**
     * 会员ip
     */
    @Column(columnDefinition = "varchar(64)")
    private String memberIp;
    /**
     * 创建时间
     */
    @Column(columnDefinition = "datetime")
    private Date createTime;
    /**
     * 显示状态[0-不显示，1-显示]
     */
    @Column(columnDefinition = "tinyint(1)")
    private Integer showStatus;
    /**
     * 购买时属性组合
     */
    @Column(columnDefinition = "varchar(255)")
    private String spuAttributes;
    /**
     * 点赞数
     */
    @Column(columnDefinition = "int")
    private Integer likesCount;
    /**
     * 回复数
     */
    @Column(columnDefinition = "int")
    private Integer replyCount;
    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @Column(columnDefinition = "varchar(1000)")
    private String resources;
    /**
     * 内容
     */
    @Column(columnDefinition = "text")
    private String content;
    /**
     * 用户头像
     */
    @Column(columnDefinition = "varchar(255)")
    private String memberIcon;
    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @Column(columnDefinition = "tinyint")
    private Integer commentType;

    /**
     * 对商品直接评论
     */
    @OneToMany(mappedBy = "spuComment", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonManagedReference
    private CommentReplayDO comment;

    /**
     * 对评论的回复
     */
    @OneToMany(mappedBy = "replyComment", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonManagedReference
    private CommentReplayDO replay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkuInfoDO getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfoDO skuInfo) {
        this.skuInfo = skuInfo;
    }

    public SpuInfoDO getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(SpuInfoDO spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getMemberIp() {
        return memberIp;
    }

    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getSpuAttributes() {
        return spuAttributes;
    }

    public void setSpuAttributes(String spuAttributes) {
        this.spuAttributes = spuAttributes;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public CommentReplayDO getComment() {
        return comment;
    }

    public void setComment(CommentReplayDO comment) {
        this.comment = comment;
    }

    public CommentReplayDO getReplay() {
        return replay;
    }

    public void setReplay(CommentReplayDO replay) {
        this.replay = replay;
    }
}
