package com.rfoe.msvc.foodie.common.event.progress;

import java.util.List;

import com.rfoe.msvc.foodie.common.enumeration.EventEnum;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;

import lombok.Getter;

public class Event {

    // map between event enum and order enum


    @Getter 
    private EventEnum event;

    @Getter 
    private OrderEnum order;

    public Event(){}
    public Event(EventEnum event,OrderEnum order ){
        this.event = event;
        this.order = order;
    }

}
