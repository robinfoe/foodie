package com.rfoe.msvc.foodie.restaurant.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rfoe.msvc.foodie.common.enumeration.MenuTypeEnum;
import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String descriptions;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    @Column(name="RESTAURANT_ID")
    private Integer restaurantId;

    @Getter
    @Setter
    private MenuTypeEnum type;

    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch=FetchType.LAZY) 
    @Getter
    @JoinColumn(name="RESTAURANT_ID",referencedColumnName="ID",insertable=false,updatable=false)
    private Restaurant restaurant;
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.setRestaurantId( (restaurant == null) ? null : restaurant.getId() );
    }

    @Override
    public Serializable getPk() {return this.getId();}

    public Menu(){}
    public Menu(Restaurant restaurant){
        this.setRestaurant(restaurant);
    }

}
