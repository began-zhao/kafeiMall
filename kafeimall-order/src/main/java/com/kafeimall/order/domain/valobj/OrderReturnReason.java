package com.kafeimall.order.domain.valobj;

import java.util.Date;

/**
 * @author: zzg
 * @date: 10/13/22
 * @Description: 订单退货原因
 */
public class OrderReturnReason {
    /**
     * id
     */
    private Long id;
    /**
     * 退货原因名
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * create_time
     */
    private Date createTime;
}
