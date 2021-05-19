package com.example.carrentaldemo.business.service;


import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.domain.CarModel;
import com.example.carrentaldemo.business.domain.Color;
import com.example.carrentaldemo.business.repo.CarRepository;
import com.example.carrentaldemo.business.service.impl.CarServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    private static Long ID = 1L;
    private static String CODE = "C1";

    @InjectMocks
    CarServiceImpl carService;

    @Mock
    CarRepository carRepository;
    Car carWork;

    @BeforeEach
    void init() {
        //   carService = new CarServiceImpl(carRepository);
        carWork = new Car(new CarModel(), 1002, Color.BLACK, "06SD456");
        carWork.setId(ID);
        carWork.setName("car");
        carWork.setCode(CODE);
    }

    @Test
    public void testFindById() {
        when(carRepository.findById(ID)).thenReturn(Optional.of(carWork));
        Optional<Car> car = carService.findById(ID);
        assertThat(car.get()).isEqualTo(carWork);
    }

    @Test
    public void testCreate() {
        when(carRepository.saveAndFlush(any(Car.class))).thenReturn(carWork);
        Car car = carService.create(carWork);
        assertThat(car).isEqualTo(carWork);

    }


    @Test
    public void testUpdate() {
        when(carRepository.saveAndFlush(any(Car.class))).thenReturn(carWork);
        Car car = carService.update(carWork);
        assertThat(car).isEqualTo(carWork);
    }

    @Test
    public void testFindByCode() {
        when(carRepository.findCarByCode(CODE)).thenReturn(Optional.of(carWork));
        Car car = carService.findByCode(CODE).get();
        assertThat(car).isEqualTo(carWork);

    }

    @Test
    public void testFindByAll() {
        PageImpl<Car> page = new PageImpl<>(Lists.list(carWork));
        when(carRepository.findAll(PageRequest.of(0, 1))).thenReturn(page);

        Page<Car> carPage = carService.findAll(PageRequest.of(0, 1));
        assertThat(carPage).isEqualTo(page);

    }


}
