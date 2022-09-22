package com.kafeimall.auth.infrastructure.facade.model.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: Oauth2获取Token返回信息封装
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenVo {
//    @ApiModelProperty("访问令牌")
    private String token;
//    @ApiModelProperty("刷令牌")
    private String refreshToken;
//    @ApiModelProperty("访问令牌头前缀")
    private String tokenHead;
//    @ApiModelProperty("有效时间（秒）")
    private int expiresIn;
}
