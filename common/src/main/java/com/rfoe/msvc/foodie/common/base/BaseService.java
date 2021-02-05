package com.rfoe.msvc.foodie.common.base;

import java.util.List;
import java.util.Optional;

import com.rfoe.msvc.foodie.common.scalar.base.BaseEntity;


public abstract class BaseService<T extends BaseEntity> {


    public List<T> getAll(){ return this.getRepo().findAll(); }

    @SuppressWarnings("unchecked")
    public T getById(Integer id){
        Optional<? extends BaseEntity> optional = this.getRepo().findById(id);
        return (T) (optional.isPresent() ?  optional.get() : null); 
    }


    // ABSTRACT MODEL //

    abstract protected BaseRepo<T> getRepo();
}
