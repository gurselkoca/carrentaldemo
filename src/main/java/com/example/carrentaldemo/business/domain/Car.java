package com.example.carrentaldemo.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
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

    public Car(CarModel model, Integer modelYear, Color color, String plate) {
        this.model = model;
        this.modelYear = modelYear;
        this.color = color;
        this.plate = plate;
    }

    public Car() {

    }
}
