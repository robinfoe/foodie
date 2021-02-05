package com.rfoe.msvc.foodie.kitchen.domain.repository;

import java.util.List;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.kitchen.domain.entity.Kitchen;

import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends BaseRepo<Kitchen>{

    public List<Kitchen> findByOrderIdandStatus(Integer orderId, String status);
    
}
