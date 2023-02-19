package com.kafeimall.lottery.repo.repository;

import com.kafeimall.lottery.domain.aggregate.DrawLottery;
import com.kafeimall.lottery.repo.cache.DrawLotteryCacheAccessObj;
import com.kafeimall.lottery.repo.dao.AwardDao;
import com.kafeimall.lottery.repo.dao.AwardPoolDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:46 AM
 * @Description: 描述：抽奖资源库，对外提供统一的资源方案，聚合资源库信息 承担存储逻辑
 */
//@Repository
public class DrawLotteryRepository {
    @Autowired
    private AwardDao awardDao;
    @Autowired
    private AwardPoolDao awardPoolDao;
    @Autowired
    private DrawLotteryCacheAccessObj drawLotteryCacheAccessObj;

    public DrawLottery getDrawLotteryById(Integer lotteryId) {
        DrawLottery drawLottery = drawLotteryCacheAccessObj.get(lotteryId);
        if (drawLottery != null) {
            return drawLottery;
        }
        drawLottery = getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccessObj.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(Integer lotteryId) {
        return null;
    }
}
