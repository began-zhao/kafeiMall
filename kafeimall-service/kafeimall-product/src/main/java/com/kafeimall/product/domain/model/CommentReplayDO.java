package com.kafeimall.product.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品评价回复关系
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Table(name = "pms_comment_replay")
public class CommentReplayDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 评论id
	 */
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id",referencedColumnName = "id")
	private SpuCommentDO spuComment;

	/**
	 * 回复id
	 */
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
	@JoinColumn(name = "reply_id",referencedColumnName = "id")
	private SpuCommentDO replyComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SpuCommentDO getSpuComment() {
		return spuComment;
	}

	public void setSpuComment(SpuCommentDO spuComment) {
		this.spuComment = spuComment;
	}

	public SpuCommentDO getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(SpuCommentDO replyComment) {
		this.replyComment = replyComment;
	}
}
