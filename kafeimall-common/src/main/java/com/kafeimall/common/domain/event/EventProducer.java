package com.kafeimall.common.domain.event;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * 简易版 EventSource 使用，没有存储
 */
@Component
public class EventProducer {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发布事件
     * @param event 事件
     */
    public void publishEvent(BaseDomainEvent event){
        kafkaTemplate.send(EventConfigProperties.Event_STORE_KAFAKA_TOPIC, JSON.toJSONString(event)).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                //发送消息失败的处理
                System.out.println("发送消息失败：" + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                //发送消息成功的日志
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });
    }

    /**
     * 事务提交，一般情况下不会用到
     * @param event
     */
    public void publishEventInTransaction(BaseDomainEvent event){
        // 声明事务：后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send(EventConfigProperties.Event_STORE_KAFAKA_TOPIC, JSON.toJSONString(event));
            throw new RuntimeException("kafka send fail");
        });
    }
}
