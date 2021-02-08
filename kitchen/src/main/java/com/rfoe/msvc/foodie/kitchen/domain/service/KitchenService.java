package com.rfoe.msvc.foodie.kitchen.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.rfoe.msvc.foodie.common.base.BaseRepo;
import com.rfoe.msvc.foodie.common.base.BaseService;
import com.rfoe.msvc.foodie.common.enumeration.OrderEnum;
import com.rfoe.msvc.foodie.common.scalar.dto.KitchenDTO;
import com.rfoe.msvc.foodie.common.scalar.dto.OrderDTO;
import com.rfoe.msvc.foodie.kitchen.domain.entity.Kitchen;
import com.rfoe.msvc.foodie.kitchen.domain.repository.KitchenRepository;
import com.rfoe.msvc.foodie.kitchen.handler.KitchenEventProducer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class KitchenService extends BaseService<Kitchen> {

    @Autowired
    private KitchenRepository repo;

    @Autowired
    private KitchenEventProducer producer;

    @Override
    protected BaseRepo<Kitchen> getRepo() {return this.repo;}



    @Transactional
    public List<KitchenDTO> getAllDTO() {

        List<Kitchen> kitchens = super.getAll();

        List<KitchenDTO> dtos = new ArrayList<KitchenDTO>();
        for (Kitchen item : kitchens) {
            dtos.add(this.convertToDTO(item));
        }

        return dtos;
    }


    @Transactional
    private KitchenDTO convertToDTO(Kitchen item) {
        KitchenDTO dto = new KitchenDTO();
        BeanUtils.copyProperties(item, dto);
        dto.getOrder().setId(item.getOrderId());
        // dto.setStatus(item.getStatus());
        return dto;
    }


    @Transactional
    public void createTicket(OrderDTO order){

        try{

            Kitchen kitchen = new Kitchen();
            kitchen.setProgress(OrderEnum.CREATED);
            kitchen.setOrderId(order.getId());
            repo.save(kitchen);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // public void acceptOrder(KitchenDTO kitchenDTO){

    //     // TODO validation allow compare - current status to next status .... 

    // }
    

    // @Transactional
    // public void progressTicket(KitchenDTO kitchenDTO){

    //     Optional<Kitchen> kitchenOption = repo.findById(kitchenDTO.getId());
    //     if(kitchenOption.isEmpty()){
    //         return;
    //     }

    //     Kitchen kitchen = kitchenOption.get();
    //     Optional<Event> event = EventProgress.getInstance().getNextEventByOrderEnum(OrderEnum.getEnum(kitchen.getStatus()));

    //     // TODO consider database rollback
    //     this.updateTicket(kitchen, event.get());
    // }

    @Transactional
    public void acceptTicket(KitchenDTO kitchenDTO){
        kitchenDTO.setProgress(OrderEnum.ACCEPTED);
        this.updateTicket(kitchenDTO);
    }

    @Transactional
    public void preparingTicket(KitchenDTO kitchenDTO){
        kitchenDTO.setProgress(OrderEnum.PREPARING);
        this.updateTicket(kitchenDTO);
    }

    @Transactional
    public void completeTicket(KitchenDTO kitchenDTO){
        kitchenDTO.setProgress(OrderEnum.COMPLETED);
        this.updateTicket(kitchenDTO);
    }

    @Transactional
    public void updateTicket(KitchenDTO kitchenDTO){

        try{

            Optional<Kitchen> kitchenOption = repo.findById(kitchenDTO.getId());
            if(kitchenOption.isEmpty()){
                return;
            }

            Kitchen kitchen = kitchenOption.get();
            kitchen.setProgress(kitchenDTO.getProgress());
            kitchenDTO.getOrder().setId(kitchen.getId());;
            repo.save(kitchen);
            this.producer.broadcastKitchenEvent(kitchenDTO);
        }catch(Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    
}
