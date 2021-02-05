package com.rfoe.msvc.foodie.common.scalar.dto;

import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class KitchenDTO extends BaseDTO{

    private int id;
    private OrderDTO order;
    private String status;
}
