package com.kafeimall.lottery.service.impl;

import com.kafeimall.lottery.domain.valobj.DrawLotteryContext;
import com.kafeimall.lottery.domain.valobj.IssueResponse;
import com.kafeimall.lottery.facade.UserCityInfoFacade;
import com.kafeimall.lottery.repo.repository.DrawLotteryRepository;
import com.kafeimall.lottery.service.AwardSendService;
import com.kafeimall.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:57 AM
 * @Description: 描述：抽奖服务实现
 */
public class LotteryServiceImpl implements LotteryService {
    @Autowired
    private DrawLotteryRepository repository;
    @Autowired
    private UserCityInfoFacade userCityInfoFacade;
    @Autowired
    private AwardSendService awardSendService;
//    @Autowired
//    private AwardCountFacade awardCountFacade;//计数上下文防腐层

    @Override
    public IssueResponse issueLottery(DrawLotteryContext context) {
//        DrawLottery lottery = repository.getDrawLotteryById(context.getLotteryId());
//        awardCountFacade.incrTryCount(context);
//        MtCity mtCityInfo = userCityInfoFacade.getMtCityInfo(context);
//        context.setMtCityInfo(mtCityInfo);
//        AwardPool awardPool = lottery.chooseAwardPool(context);
//        Award award = awardPool.randomGetAward();
//        return buildIssueResponse(awardSendService.sendAward(award, context));
        return null;
    }

//    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {
//        IssueResponse issueResponse = new IssueResponse();
//        return null;
//    }
}
