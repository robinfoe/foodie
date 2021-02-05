package com.rfoe.msvc.foodie.order.domain.entity;

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
import javax.persistence.Table;

import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.scalar.Address;
import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ODR")
@SuppressWarnings("serial")
public class Order extends BaseEntity{
    

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer restaurantId;

    @Getter @Setter
    private Integer consumerId;

    @Embedded
    @Getter @Setter
    private Address deliveryAddress = new Address();

    @Getter @Setter
    private OrderEnum progress = OrderEnum.CREATED;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetail> orders = new ArrayList<OrderDetail>();
    public List<OrderDetail> getOrderDetail(){ return this.orders; }
    public OrderDetail addDetail(){
        OrderDetail item = new OrderDetail(this);
        this.orders.add(item);
        return item;
    }
    
    @Override
    public Serializable getPk() {return this.getId();}

    public boolean isCreated(){return OrderEnum.CREATED.equals(progress);}
    public boolean isCancelled(){return OrderEnum.CANCELLED.equals(progress);}
    public boolean isAccepted(){return OrderEnum.ACCEPTED.equals(progress);}
    public boolean isPreparing(){return OrderEnum.PREPARING.equals(progress);}
    public boolean isCompleted(){return OrderEnum.COMPLETED.equals(progress);}
}
