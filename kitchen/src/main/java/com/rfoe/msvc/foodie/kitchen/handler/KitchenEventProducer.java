package com.rfoe.msvc.foodie.kitchen.handler;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.common.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.FluxSink;

/**
 * KitchenEventProducer
 */

@Service
@Slf4j
public class KitchenEventProducer {

    @Autowired
    private FluxSink<String> kitchenEventChannel;

    public void broadcastKitchenEvent(final KitchenDTO kitchen)throws Exception{
        String kitchenJSON = JsonUtil.getInstance().getMapper().writeValueAsString(kitchen);
        log.info(kitchenJSON);
        this.kitchenEventChannel.next(kitchenJSON);
    }

    
}