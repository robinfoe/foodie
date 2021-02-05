package com.rfoe.msvc.foodie.common.scalar.dto;

import java.util.ArrayList;
import java.util.List;

import com.rfoe.msvc.foodie.common.scalar.Address;
import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class RestaurantDTO extends BaseDTO{

    private Integer id;
    private String name;
    private Address address;
    private List<MenuDTO> menus = new ArrayList<MenuDTO>();

    public MenuDTO addMenu(){
        menus.add(new MenuDTO());
        return menus.get(menus.size() -1 );
    }
    
}
