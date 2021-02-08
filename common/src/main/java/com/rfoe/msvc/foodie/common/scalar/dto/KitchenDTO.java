package com.rfoe.msvc.foodie.common.scalar.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.event.progress.Event;
import com.rfoe.msvc.foodie.common.event.progress.EventProgress;
import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class KitchenDTO extends BaseDTO{

    private int id;
    private OrderDTO order = new OrderDTO();
    private OrderEnum progress;

    public void setProgress(OrderEnum orderEnum){
        Optional<Event> event = EventProgress.getInstance().getCurrentEventByOrderEnum(orderEnum);
        if(event.isPresent()){
            super.setEventType(event.get().getEvent());
        }
    }
}
