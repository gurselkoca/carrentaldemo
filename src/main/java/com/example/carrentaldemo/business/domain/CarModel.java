package com.example.carrentaldemo.business.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
//@Table(uniqueConstraints =
//@UniqueConstraint(columnNames = {"code"}))
public class CarModel extends NameCodeEntity {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private BigDecimal dailyCost;

}
