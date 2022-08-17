package com.kafeimall.lottery.service;

import com.kafeimall.lottery.domain.valobj.DrawLotteryContext;
import com.kafeimall.lottery.domain.valobj.IssueResponse;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:55 AM
 * @Description: 描述：抽奖领域服务
 */
public interface LotteryService {
    IssueResponse issueLottery(DrawLotteryContext context);
}
