package com.rfoe.msvc.foodie.common.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo<T> extends JpaRepository<T, Integer> {

    public List<T> findByStatus(String status);
    
}
