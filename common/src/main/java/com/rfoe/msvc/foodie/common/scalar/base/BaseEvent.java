package com.rfoe.msvc.foodie.common.scalar.base;

import com.rfoe.msvc.foodie.common.enumeration.EventEnum;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseEvent {

    @Getter @Setter
    private EventEnum event;

    protected BaseEvent(EventEnum event){
        this.event = event;
    }

}
