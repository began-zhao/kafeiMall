package com.kafeimall.lottery.repo.cache;

import com.kafeimall.lottery.domain.aggregate.DrawLottery;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:41 AM
 * @Description: 抽奖缓存对象
 */
public class DrawLotteryCacheAccessObj {
    private static final Map<Integer, DrawLottery> DRAW_LOTTERY_CACHE = new HashMap<>();

    public DrawLottery get(Integer lotteryId) {
        return DRAW_LOTTERY_CACHE.get(lotteryId);
    }

    public void add(Integer lotteryId, DrawLottery drawLottery) {
        DRAW_LOTTERY_CACHE.put(lotteryId, drawLottery);
    }
}
