package com.rfoe.msvc.foodie.order.handler;

import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.order.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("api/order")
public class OrderWebHandler {

    @Autowired
    OrderService service;

    @PostMapping(
            path = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public OrderDTO create(@RequestBody OrderDTO formData) {
        service.submitOrder(formData);


		return formData;
	}
    
}
