package com.rfoe.msvc.foodie.consumer.domain.repository;

import java.util.List;

import com.rfoe.msvc.foodie.consumer.domain.entity.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{

    public List<Consumer> findByEmailIgnoreCase(String email);
    
}
