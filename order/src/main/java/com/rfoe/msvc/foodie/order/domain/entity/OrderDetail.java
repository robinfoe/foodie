package com.rfoe.msvc.foodie.order.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ODR_DET")
@SuppressWarnings("serial")
public class OrderDetail extends BaseEntity{

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name="ORDER_ID")
    private Integer orderId;

    @Getter
    @Setter
    @Column(name="MENU_ID")
    private Integer menuId;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private double price;


    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch=FetchType.LAZY) 
    @Getter
    @JoinColumn(name="ORDER_ID",referencedColumnName="ID",insertable=false,updatable=false)
    private Order order;
    public void setOrder(Order order) {
        this.order = order;
        this.setOrderId( (order == null) ? null : order.getId() );
    }

    @Override
    public Serializable getPk() {return this.getId();}

    public OrderDetail(){}
    public OrderDetail(Order order){
        this.setOrder(order);
    }

    
}
