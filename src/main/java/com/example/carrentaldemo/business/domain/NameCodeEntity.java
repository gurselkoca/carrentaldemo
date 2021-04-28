package com.example.carrentaldemo.business.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class NameCodeEntity extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;


    @Column(nullable = false)
    private String code;

}
