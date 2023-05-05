package com.kafeimall.order.domain.model.valobj;


import com.kafeimall.order.domain.model.entity.SubmitOrderItem;
import lombok.Data;

import java.util.List;

/**
 * @author: zzg
 * @date: 2022/11/19
 * @Description: 远程锁库存信息
 */
@Data
public class WareSkuLock {
    private String orderSn; //订单号
    private List<SubmitOrderItem> locks;//需要锁住的所有库存信息
}
