package com.kafeimall.product.domain.eventHandles;

import org.springframework.context.ApplicationEvent;

/**
 * @author: zzg
 * @date: 2023/1/1
 * @Description: zzg
 */
public class ProductEvent extends ApplicationEvent {
    public ProductEvent(Object source) {
        super(source);
    }
}
