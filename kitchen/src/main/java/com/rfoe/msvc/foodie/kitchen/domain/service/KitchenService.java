package com.rfoe.msvc.foodie.kitchen.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.common.base.BaseService;
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
    public void updateTicket(KitchenDTO kitchenDTO, String progress){

        try{


            Optional<Kitchen> kitchenOption =repo.findById(kitchenDTO.getId());
            if(kitchenOption.isEmpty()){
                return;
            }
            // call webservice for order status ? need to decide here .... 
            // Kitchen kitchen = kitchenOption.get();

            // kitchen.setStatus(status);
            // Kitchen kitchen = new Kitchen();
            // kitchen.setOrderId(kitchenDTO.getOrder().getId());
            // repo.save(kitchen);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
