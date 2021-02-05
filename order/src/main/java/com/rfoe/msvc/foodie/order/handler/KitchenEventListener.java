package com.rfoe.msvc.foodie.order.handler;

import com.rfoe.msvc.foodie.order.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenEventListener {

    @Autowired
    private OrderService service;


    public void consumeKitchenEvent(String eventText){
        // TODO :: work on jackson marshalling ....


        // if(PaymentEnum.IGNORED.equals(event.getStatus())){
        //     return;
        // }

        // this.repo.findById(event.getOrderId())
        //     .ifPresent(purchaseOrder -> {
        //         purchaseOrder.setStatus(
        //             PaymentEnum.APPROVED.equals(event.getStatus()) ? OrderEnum.COMPLETED : OrderEnum.CANCELLED
        //         );
        //         this.repo.save(purchaseOrder);
        //     });
    }

    
}
