package com.kafeimall.lottery.facade;

import com.kafeimall.lottery.domain.entity.MtCity;
import com.kafeimall.lottery.domain.valobj.DrawLotteryContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zzg
 * @Date: 8/17/22 8:31 AM
 * @Description: 用户城市信息防腐层，访问外部信息，增加一层处理
 */
//@Component
public class UserCityInfoFacade {
    @Autowired
//    private LbsService lbsService;//外部用户城市信息RPC服务

    public MtCity getMtCityInfo(DrawLotteryContext context) {
//        LbsReq  lbsReq = new LbsReq();
//        lbsReq.setLan(context.getLan());
//        lbsReq.setLat(context.getLat());
//        LbsResponse lbsResponse = lbsService.getLbsCityInfo(lbsReq);
//        return buildMtCityInfo(lbsResponse);
        return null;
    }

//    private MtCity buildMtCityInfo(LbsResponse lbsResponse) {
//        // 增加一层处理转换
//        return null;
//    }
}
