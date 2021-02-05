package com.rfoe.msvc.foodie.consumer.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfoe.msvc.foodie.common.scalar.event.ConsumerEvent;
import com.rfoe.msvc.foodie.consumer.domain.entity.Consumer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.FluxSink;

@Service
public class ConsumerEventProducer {


    // @Autowired
    // private FluxSink<String> consumerEventChannel;

    // public void raiseConsumerCreatedEvent(final Consumer consumer) throws Exception{
        
    //     ConsumerEvent event = new ConsumerEvent();
    //     BeanUtils.copyProperties(consumer, event);

    //     ObjectMapper mapper = new ObjectMapper();
    //     String json = mapper.writeValueAsString(event);
    //     // System.out.println(json);

    //     this.consumerEventChannel.next(json);
    // }
    
}
