package com.rfoe.msvc.foodie.consumer.domain.service;

import java.util.Optional;

import com.rfoe.msvc.foodie.common.scalar.dto.ConsumerDTO;
import com.rfoe.msvc.foodie.consumer.domain.entity.Consumer;
import com.rfoe.msvc.foodie.consumer.domain.repository.ConsumerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository repo;

    @Autowired
    private ConsumerEventProducer event;

    public ConsumerDTO getById(Integer id){
        ConsumerDTO dto = new ConsumerDTO();
        Optional<Consumer> consumerOption = repo.findById(id);
        if(consumerOption.isPresent()){
            BeanUtils.copyProperties(consumerOption.get(), dto);
        }

        return dto;
    }

    public Consumer create(Consumer consumer){
        try{
            repo.save(consumer);
            // event.raiseConsumerCreatedEvent(consumer);
            
            return consumer;
        }catch(Exception e ){
            e.printStackTrace();
        }


        return null;
        
    }
    
}
