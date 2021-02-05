package com.rfoe.msvc.foodie.common.scalar.dto;

import java.util.ArrayList;
import java.util.List;

import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class OrderDTO extends BaseDTO{

    private Integer id;
    private RestaurantDTO restaurant = new RestaurantDTO();
    private ConsumerDTO consumer = new ConsumerDTO();
    private List<MenuDTO> menus = new ArrayList<MenuDTO>();
    private OrderEnum progress = OrderEnum.CREATED;
    
}
