package com.kafeimall.product.httpapi.controller;

import com.kafeimall.common.domain.event.EventConfigProperties;
import com.kafeimall.common.domain.event.EventProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EventTestController {

    @Resource
    EventProducer eventProducer;
    // 发送消息
    @PostMapping("/kafka/normal/send")
    public void sendMessage1(@RequestBody TestDomain normalMessage) {
        eventProducer.publishEvent(normalMessage);
    }


    // 消费监听
    @KafkaListener(topics = {EventConfigProperties.Event_STORE_KAFAKA_TOPIC})
    public void onMessage1(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }
}
