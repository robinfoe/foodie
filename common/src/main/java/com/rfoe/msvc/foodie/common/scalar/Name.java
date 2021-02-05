package com.rfoe.msvc.foodie.common.scalar;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Name {

    private String first;
    private String last;
    
}
