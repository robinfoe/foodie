package com.rfoe.msvc.foodie.kitchen.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.common.util.JsonUtil;
import com.rfoe.msvc.foodie.kitchen.domain.service.KitchenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderEventListener {

    @Autowired
    private KitchenService service;



    public void orderCreated(String eventText){
        try{

            log.info(eventText);

            OrderDTO dto = JsonUtil.getInstance().getMapper().readValue(eventText.getBytes(), OrderDTO.class);
            service.createTicket(dto);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
}
