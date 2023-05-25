package com.kafeimall.common.domain.event;

public interface EventConfigProperties {

    /**
     * 领域事件订阅主题
     */
     String Event_STORE_KAFAKA_TOPIC = "";
    /**
     *
     */
     String Event_STORE_FAILURE_REPORT_TOPIC = "";
    /**
     *
     */
     String Event_STORE_FAILURE_RETRY_TOPIC = "";
}
