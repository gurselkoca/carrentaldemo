package com.example.carrentaldemo.business.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
//@Table(uniqueConstraints =
//@UniqueConstraint(columnNames = {"code"}))
public class Car extends NameCodeEntity{
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarModel model;

    @Column(nullable = false)
    private Integer modelYear;

    @Column
    private Color color;

    @Column(nullable = false)
    String plate;








}
