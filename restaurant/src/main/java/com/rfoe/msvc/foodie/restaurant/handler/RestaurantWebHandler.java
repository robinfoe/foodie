package com.rfoe.msvc.foodie.restaurant.handler;

import java.util.List;

import com.rfoe.msvc.foodie.common.scalar.dto.RestaurantDTO;
import com.rfoe.msvc.foodie.restaurant.domain.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/restaurant")
public class RestaurantWebHandler {

    @Autowired
    private RestaurantService service;

    
    @GetMapping(
        path = "get",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<RestaurantDTO>getAllRestaurant(){
        return service.getAllDTO();
    }


    @GetMapping(
        path = "get/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestaurantDTO getRestaurantById(@PathVariable(value="id") Integer id){
        return service.getDTOById(id);
    }

    
}
