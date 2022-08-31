package com.kafeimall.product.infrastructure.repo.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品评价回复关系
 * 
 * @author zzg
 * @email 834561898@gmail.com
 * @date 2021-08-16 16:12:39
 */
@Data
@TableName("pms_comment_replay")
public class CommentReplayPO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 评论id
	 */
	private Long commentId;
	/**
	 * 回复id
	 */
	private Long replyId;

}
