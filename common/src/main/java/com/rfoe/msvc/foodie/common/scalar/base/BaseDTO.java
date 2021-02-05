package com.rfoe.msvc.foodie.common.scalar.base;

import java.io.Serializable;

import com.rfoe.msvc.foodie.common.constant.ConstantBoolean;
import com.rfoe.msvc.foodie.common.enumeration.EventEnum;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public abstract class BaseDTO implements Serializable{

    @Getter @Setter
    private EventEnum eventType;

    @Getter @Setter
    private String message;
    
    @Getter @Setter
    private String errorMessage;
    
    protected String success = ConstantBoolean.YES;

    public void error(String text){
        this.errorMessage = text;
        this.success = ConstantBoolean.NO;
    }

    public void success(String text){
        this.errorMessage = text;
        this.message = ConstantBoolean.YES;
    }


    
}
