package com.rfoe.msvc.foodie.common.enumeration;

import lombok.Getter;

public enum OrderEnum {

    CREATED("C"),
    ACCEPTED("A"),
    PREPARING("P"),
    DELIVER("D"),
    COMPLETED("T"),
    INVALID("I"),
    CANCELLED("D");

    @Getter
    final String status;


    private OrderEnum(String status){
        this.status = status;
    }

    public static OrderEnum getEnum(String text){
        
        for ( OrderEnum item : OrderEnum.values()){
            if(item.getStatus().equals(text)){
                return item;
            }
        }
        return null;
    }

    public static OrderEnum getNextStatus(String currentStatus){
        return OrderEnum.getNextStatus(OrderEnum.getEnum(currentStatus));
    }

    public static OrderEnum getNextStatus(OrderEnum currentStatus){
        OrderEnum nextStatus = OrderEnum.INVALID;
        switch (currentStatus){
            case CREATED : nextStatus = ACCEPTED; break;
            case ACCEPTED : nextStatus = PREPARING; break;
            case PREPARING : nextStatus = COMPLETED; break;
            default: ;
        }

        return nextStatus;
    }






    
}
