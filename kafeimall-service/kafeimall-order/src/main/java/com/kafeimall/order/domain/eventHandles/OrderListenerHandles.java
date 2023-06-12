package com.kafeimall.order.domain.eventHandles;

import com.kafeimall.common.domain.event.EventConfigProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * MQ消息通知
 */
@Component
public class OrderListenerHandles {

    /**
     * 监听关单信息
     * @param record
     */
    @KafkaListener(topics = {EventConfigProperties.Event_STORE_KAFAKA_TOPIC})
    public void orderCloseListener(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }

    /**
     * 监听秒杀单信息
     * @param record
     */
    @KafkaListener(topics = {EventConfigProperties.Event_STORE_KAFAKA_TOPIC})
    public void orderSeckillListener(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }
}
