package com.rfoe.msvc.foodie.restaurant.domain.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.common.base.BaseService;
import com.rfoe.msvc.foodie.common.scalar.dto.MenuDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.RestaurantDTO;
import com.rfoe.msvc.foodie.restaurant.domain.entity.Menu;
import com.rfoe.msvc.foodie.restaurant.domain.entity.Restaurant;
import com.rfoe.msvc.foodie.restaurant.domain.repository.RestaurantRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends BaseService<Restaurant> {

    @Autowired
    private RestaurantRepository repo;


    @Transactional
    public List<RestaurantDTO> getAllDTO() {

        List<Restaurant> restaurants = super.getAll();

        List<RestaurantDTO> dtos = new ArrayList<RestaurantDTO>();
        for (Restaurant item : restaurants) {
            dtos.add(this.convertToDTO(item));
        }

        return dtos;
    }

    @Transactional
    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();

        BeanUtils.copyProperties(restaurant, dto, "menus");

        for (Menu menu : restaurant.getMenus()) {
            MenuDTO item = dto.addMenu();
            System.err.println(menu.getId());
            BeanUtils.copyProperties(menu, item);
        }

        return dto;
    }


    @Transactional
    public RestaurantDTO getDTOById(Integer id){
        Restaurant item = super.getById(id);
        RestaurantDTO dto = new RestaurantDTO();
        if(item!=null){
            dto = this.convertToDTO(item);
        }
        return dto;
    }

    @Override
    protected BaseRepo<Restaurant> getRepo() { return this.repo; }


    
}
