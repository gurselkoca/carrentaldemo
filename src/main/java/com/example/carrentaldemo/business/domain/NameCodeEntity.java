package com.example.carrentaldemo.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class NameCodeEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String code;

    public NameCodeEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public NameCodeEntity() {
    }
}
