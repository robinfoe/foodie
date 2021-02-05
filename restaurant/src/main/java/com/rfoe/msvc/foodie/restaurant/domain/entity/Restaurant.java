package com.rfoe.msvc.foodie.restaurant.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.rfoe.msvc.foodie.common.scalar.Address;
import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Restaurant
 */

@Entity
@SuppressWarnings("serial")
public class Restaurant extends BaseEntity{

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @Embedded
    @Getter @Setter
    private Address address = new Address();

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Menu> menus = new ArrayList<Menu>();
    public List<Menu> getMenus(){ return this.menus; }
    public Menu addMenu(){
        Menu menu = new Menu(this);
        this.menus.add(menu);
        return menu;
    }
    
    @Override
    public Serializable getPk() {return this.getId();}

}