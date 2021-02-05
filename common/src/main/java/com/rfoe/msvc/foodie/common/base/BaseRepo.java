package com.rfoe.msvc.foodie.common.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo<T> extends JpaRepository<T, Integer> {
    
}
