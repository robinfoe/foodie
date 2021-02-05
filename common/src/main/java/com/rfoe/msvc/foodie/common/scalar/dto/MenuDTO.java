package com.rfoe.msvc.foodie.common.scalar.dto;

import com.rfoe.msvc.foodie.common.enumeration.MenuTypeEnum;
import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class MenuDTO extends BaseDTO{

    private Integer id;
    private String name;
    private String descriptions;
    private MenuTypeEnum type;
    private double price;

    private Integer quantity;
    
}
