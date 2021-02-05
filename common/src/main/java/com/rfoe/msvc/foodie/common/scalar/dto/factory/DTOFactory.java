package com.rfoe.msvc.foodie.common.scalar.dto.factory;

import com.rfoe.msvc.foodie.common.enumeration.EventEnum;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;

public class DTOFactory {

    private DTOFactory(){/* No Object creation*/}

    public static OrderDTO  orderSubmitedEvent(){

        OrderDTO item = new OrderDTO();
        item.setEventType(EventEnum.DOMAIN_ORDER_CREATED);
        
        return item;
    }
    
}
