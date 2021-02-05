package com.rfoe.msvc.foodie.common.scalar.dto;

import com.rfoe.msvc.foodie.common.scalar.Address;
import com.rfoe.msvc.foodie.common.scalar.Name;
import com.rfoe.msvc.foodie.common.scalar.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")
public class ConsumerDTO extends BaseDTO{

    private int id;
    private Name name = new Name();
    private Address homeAddress = new Address();
    private String email;
    
}
