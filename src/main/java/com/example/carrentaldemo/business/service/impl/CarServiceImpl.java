package com.example.carrentaldemo.business.service.impl;

import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.repo.CarRepository;
import com.example.carrentaldemo.business.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;

    }


    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car create(Car carWork) {
        return carRepository.saveAndFlush(carWork);
    }

    @Override
    public Car update(Car carWork) {
        return carRepository.saveAndFlush(carWork);
    }

    @Override
    public Optional<Car> findByCode(String code) {
        return carRepository.findCarByCode(code);
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }


}
