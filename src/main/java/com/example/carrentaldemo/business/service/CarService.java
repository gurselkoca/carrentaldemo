package com.example.carrentaldemo.business.service;

import com.example.carrentaldemo.business.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarService {
    Optional<Car> findById(Long id);

    Car create(Car carWork);

    Car update(Car carWork);

    Optional<Car> findByCode(String code);

    Page<Car> findAll(Pageable pageable);
}
