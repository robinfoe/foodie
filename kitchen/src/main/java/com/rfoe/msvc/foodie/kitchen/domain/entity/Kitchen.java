package com.rfoe.msvc.foodie.kitchen.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
public class Kitchen extends BaseEntity{
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer orderId;
    
    @Override
    public Serializable getPk() {return this.getId();}

}
