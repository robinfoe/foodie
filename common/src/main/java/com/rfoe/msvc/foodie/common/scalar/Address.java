package com.rfoe.msvc.foodie.common.scalar;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String addr01;
    private String addr02;
    private String postcode;
    private String country;
    private String state;
    
}
