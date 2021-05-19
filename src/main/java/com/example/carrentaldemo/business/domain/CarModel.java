package com.example.carrentaldemo.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CarModel extends NameCodeEntity {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private BigDecimal dailyCost;

}
