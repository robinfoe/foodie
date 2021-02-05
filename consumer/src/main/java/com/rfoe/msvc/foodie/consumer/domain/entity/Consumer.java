package com.rfoe.msvc.foodie.consumer.domain.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.rfoe.msvc.foodie.common.scalar.Address;
import com.rfoe.msvc.foodie.common.scalar.Name;
import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
public class Consumer extends BaseEntity {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Embedded
    @Getter @Setter
    private Name name = new Name();

    @Embedded
    @Getter @Setter
    private Address homeAddress = new Address();


    @Getter @Setter
    private String email;

    @Override
    public Serializable getPk(){ return this.getId(); }
    
}