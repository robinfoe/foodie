package com.rfoe.msvc.foodie.order.handler;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rfoe.msvc.foodie.common.enumeration.EventEnum;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.FluxSink;

@Service
public class OrderEventProducer {

    private static final ObjectMapper objectMapper = JsonMapper.builder().build();

    @Autowired
    private FluxSink<String> orderEventChannel;

    public void raiseOrderCreatedEvent(final OrderDTO order)throws Exception{
        try{
            order.setEventType(EventEnum.DOMAIN_ORDER_CREATED);

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter orderJson = new StringWriter();
            objectMapper.writeValue(orderJson, order);
            System.err.println(orderJson);
            this.orderEventChannel.next(orderJson.toString());

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
}
