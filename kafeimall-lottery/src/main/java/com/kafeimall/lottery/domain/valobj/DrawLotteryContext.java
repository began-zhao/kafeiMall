package com.kafeimall.lottery.domain.valobj;

import com.kafeimall.lottery.domain.entity.MtCity;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:29 AM
 * @Description: 抽奖上下文
 */
public class DrawLotteryContext {
    private MtCity mtCityInfo;
    private String gameScore;
    private String lan;
    private String lat;
    private Long userId;

    public MtCity getMtCityInfo() {
        return mtCityInfo;
    }

    public void setMtCityInfo(MtCity mtCityInfo) {
        this.mtCityInfo = mtCityInfo;
    }

    public String getGameScore() {
        return gameScore;
    }

    public String getLan() {
        return lan;
    }

    public String getLat() {
        return lat;
    }

    public Integer getLotteryId() {
        return 123;
    }

    public Long getUserId() {
        return userId;
    }
}
