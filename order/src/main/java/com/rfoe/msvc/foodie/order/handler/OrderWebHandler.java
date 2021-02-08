package com.rfoe.msvc.foodie.order.handler;

import java.util.List;

import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.order.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController()
@RequestMapping("api/order")
@Slf4j
public class OrderWebHandler {

    @Autowired
    OrderService service;


    @GetMapping(
        path = "get",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<OrderDTO>getAllKitchenOrder(){
        return service.getAllDTO();
    }

    @PostMapping(
            path = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public OrderDTO create(@RequestBody OrderDTO formData) {
        log.info("Incoming order....");
        service.submitOrder(formData);
		return formData;
	}
    
}
