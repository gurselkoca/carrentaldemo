package com.example.carrentaldemo.web.controller;

import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.domain.CarModel;
import com.example.carrentaldemo.business.domain.Color;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {


    @Mock
    CarServiceImpl carService;

    @InjectMocks
    CarController carController;

    Car carWork;

    private static Long ID = 1L;
    private static String CODE = "C1";

    @BeforeEach
    void init() {
        //   carService = new CarServiceImpl(carService);
        carWork = new Car(new CarModel(), 1002, Color.BLACK, "06SD456");
        carWork.setId(ID);
        carWork.setName("car");
        carWork.setCode(CODE);
    }

    @Test
    public void testfindAll() {
        PageImpl<Car> page = new PageImpl<>(Lists.list(carWork));
        when(carService.findAll(PageRequest.of(0, 1))).thenReturn(page);

        Page<Car> carPage = carController.findAll(PageRequest.of(0, 1));
        assertThat(carPage).isEqualTo(page);
    }


    @Test
    public void testFindById() {
        when(carService.findById(ID)).thenReturn(Optional.of(carWork));
        Car car = carController.findById(ID);
        assertThat(car).isEqualTo(carWork);
    }

    @Test
    public void testCreate() {
        when(carService.create(carWork)).thenReturn(carWork);
        Car car = carController.create(carWork);
        assertThat(car).isEqualTo(carWork);

    }

    @Test
    public void testUpdate() {
        when(carService.update(carWork)).thenReturn(carWork);
        Car car = carController.update(carWork);
        assertThat(car).isEqualTo(carWork);
    }

    @Test
    public void testFindByCode() {
        when(carService.findByCode(CODE)).thenReturn(Optional.of(carWork));
        Car car = carController.findByCode(CODE);
        assertThat(car).isEqualTo(carWork);

    }


}
