package com.rfoe.msvc.foodie.common.scalar.event;

import com.rfoe.msvc.foodie.common.enumeration.EventEnum;
import com.rfoe.msvc.foodie.common.scalar.Name;
import com.rfoe.msvc.foodie.common.scalar.base.BaseEvent;

import lombok.Data;

@Data
public class ConsumerEvent extends BaseEvent{

    private Name name;
    private Integer id;

    public ConsumerEvent(){
        super(EventEnum.DOMAIN_CONSUMER_CREATED);
    }
}
