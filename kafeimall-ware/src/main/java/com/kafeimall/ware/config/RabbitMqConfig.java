package com.kafeimall.ware.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zzg
 * @date: 2022/11/23
 * @Description: 消息队列相关配置
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 使用JSON序列化机制，进行消息转换
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    /**
     * 第一次监听消息时才会创建配置项
     * @throws
     */
//    @RabbitListener(queues="stock.release.stock.queue")
//    public void handle( Message message) {
//        System.out.println("接收到过期的订单信息，准备关闭订单");
//    }

    @Bean
    public Exchange stockEventExchange() {
        TopicExchange exchange = new TopicExchange("stock-event-exchange", true, false);
        return exchange;
    }

    @Bean
    public Queue stockRelealseStockQueue() {
        Queue queue = new Queue("stock.release.stock.queue", true, false, false);
        return queue;
    }

    @Bean
    public Queue stockDelayQueue() {
        Map<String, Object> arguments = new HashMap<>();
        //死信路由交换机
        arguments.put("x-dead-letter-exchange", "stock-event-exchange");
        //死信路由路由键
        arguments.put("x-dead-letter-routing-key", "stock.release");
        //死信路由过期时间
        arguments.put("x-message-ttl", 120000);
        Queue queue = new Queue("stock.delay.queue", true, false, false, arguments);
        return queue;
    }

    /**
     * 普通队列绑定关系
     * @return
     */
    @Bean
    public Binding stockReleaseBinding(){
        Binding binding = new Binding("stock.release.stock.queue",
                Binding.DestinationType.QUEUE,
                "stock-event-exchange",
                "stock.release.#",null);
        return  binding;
    }

    /**
     * 延时队列绑定关系
     * @return
     */
    @Bean
    public Binding stockLockedBinding(){
        Binding binding = new Binding("stock.delay.queue",
                Binding.DestinationType.QUEUE,
                "stock-event-exchange",
                "stock.locked",null);
        return  binding;
    }

}
