package com.kafeimall.auth.infrastructure.facade.model.vo;

import lombok.Data;

/**
 * @author: zzg
 * @date: 9/22/22
 * @Description: zzg
 */
@Data
public class SocialUser {
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}
