package com.rfoe.msvc.foodie.order.handler;

import com.rfoe.msvc.foodie.order.domain.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.FluxSink;

@Service
public class OrderEventProducer {


    @Autowired
    private FluxSink<String> orderEventChannel;

    // TODO :: fix this....
    public void raiseOrderCreatedEvent(final Order order){
        // OrderDTO orderEvent = new OrderDTO();
        
        // orderEvent.setUserId(purchaseOrder.getUserId());
        // orderEvent.setPrice(purchaseOrder.getPrice());
        // orderEvent.setOrderId(purchaseOrder.getId());

        // this.orderEventChannel.next(orderEvent);
    }
    
}
