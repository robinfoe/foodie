package com.rfoe.msvc.foodie.consumer.handler;

import com.rfoe.msvc.foodie.common.scalar.dto.ConsumerDTO;
import com.rfoe.msvc.foodie.consumer.domain.service.ConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/consumer")
public class ConsumerWebHandler {

    @Autowired
    private ConsumerService service;

    @PostMapping(
            path = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ConsumerDTO create(@RequestBody ConsumerDTO formData) {
        return formData;
    }


    @GetMapping(
            path = "/get/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ConsumerDTO get(@PathVariable(value="id") Integer id) {
        return service.getById(id);
    }


    
    
    
}
