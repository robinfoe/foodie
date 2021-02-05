package com.rfoe.msvc.foodie.order.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.order.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenEventListener {

    @Autowired
    private OrderService service;

    private static final ObjectMapper objectMapper = JsonMapper.builder().build();


    public void consumeKitchenEvent(String eventText){
        try{
            KitchenDTO kitchenDTO = objectMapper.readValue(eventText.getBytes(), KitchenDTO.class);
            service.updateKitchenProgress(kitchenDTO);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
}
