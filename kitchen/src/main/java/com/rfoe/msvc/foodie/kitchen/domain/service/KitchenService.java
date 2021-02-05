package com.rfoe.msvc.foodie.kitchen.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.common.base.BaseService;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.kitchen.domain.entity.Kitchen;
import com.rfoe.msvc.foodie.kitchen.domain.repository.KitchenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenService extends BaseService<Kitchen> {

    @Autowired
    private KitchenRepository repo;

    @Override
    protected BaseRepo<Kitchen> getRepo() {return this.repo;}


    @Transactional
    public void createTicket(OrderDTO order){

        try{

            Kitchen kitchen = new Kitchen();
            kitchen.setOrderId(order.getId());
            repo.save(kitchen);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void progressTicket(KitchenDTO kitchenDTO){

        Optional<Kitchen> kitchenOption =repo.findById(kitchenDTO.getId());
        if(kitchenOption.isEmpty()){
            return;
        }

        Kitchen kitchen = kitchenOption.get();
        OrderEnum statusEnum = OrderEnum.getNextStatus(kitchen.getStatus());
        this.updateTicket(kitchen, statusEnum);
    }

    @Transactional
    private void updateTicket(Kitchen kitchen, OrderEnum statusEnum){

        try{

            kitchen.setStatus(statusEnum.getStatus());
            KitchenDTO dto = new KitchenDTO();
            dto.setId(kitchen.getId());
            dto.getOrder().setId(kitchen.getOrderId());
// TODO :: consider eventing progress... need to find appropriate design pattern

            // dto.setEventType(eventType);


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    
}
