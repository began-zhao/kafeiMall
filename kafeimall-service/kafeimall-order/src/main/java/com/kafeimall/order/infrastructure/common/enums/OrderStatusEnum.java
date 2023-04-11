package com.kafeimall.order.infrastructure.common.enums;

/**
 * @author: zzg
 * @date: 2022/11/20
 * @Description: 订单状态枚举
 */
public enum OrderStatusEnum {
    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    CRETAE_NEW(0, "代付款"),
    PAYED(1, "已付款"),
    SENDED(2, "已发货"),
    RECIEVED(3, "已完成"),
    CANCLED(4, "已取消"),
    SERVICING(5, "售后中"),
    SERVICED(6, "售后完成");

    private int code;
    private String msg;

    OrderStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
