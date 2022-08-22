package com.kafeimall.common.event;

/**
 * @author: zzg
 * @date: 8/22/22
 * @Description: 领域事件发布接口
 */
public interface DomainEventPublisher {
    /**
     * 发布事件
     *
     * @param event 领域事件
     */
    void publishEvent(BaseDomainEvent event);
}
