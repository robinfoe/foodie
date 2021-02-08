package com.rfoe.msvc.foodie.kitchen.handler;

import java.util.List;

import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.kitchen.domain.service.KitchenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("api/kitchen")
@Slf4j
public class KitchenWebHandler {

    @Autowired
    KitchenService service;


    @GetMapping(
        path = "get",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<KitchenDTO>getAllKitchenOrder(){
        return service.getAllDTO();
    }

    @PostMapping(
            path = "accept",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public KitchenDTO accept(@RequestBody KitchenDTO formData) {
        log.info("Accepting order... ");
        this.service.acceptTicket(formData);
        // service.acceptOrder(formData);
		return formData;
    }
    

    @PostMapping(
        path = "prepare",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public KitchenDTO prepare(@RequestBody KitchenDTO formData) {
        log.info("Preparing order... ");
        this.service.preparingTicket(formData);
        return formData;
    }


@PostMapping(
    path = "complete",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public KitchenDTO complete(@RequestBody KitchenDTO formData) {
    log.info("Completing order... ");
    this.service.completeTicket(formData);
    return formData;
    }
    
    
}
