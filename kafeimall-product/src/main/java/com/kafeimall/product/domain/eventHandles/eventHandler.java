package com.kafeimall.product.domain.eventHandles;

import org.springframework.context.ApplicationEvent;

/**
 * @author: zzg
 * @date: 2022/11/26
 * @Description: 领域事件处理
 */
public class eventHandler extends ApplicationEvent {

    public eventHandler(Object source) {
        super(source);
    }
}
