package com.example.carrentaldemo.business.service;


import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.domain.CarModel;
import com.example.carrentaldemo.business.domain.Color;
import com.example.carrentaldemo.business.repo.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class CarServiceTestIT {
    private static Long ID = 1L;
    private static String CODE = "FIAT_EGEA1";

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;


    Car carWork;

    @BeforeEach
    void init() {
        //   carService = new CarServiceImpl(carRepository);
        carWork = new Car(new CarModel(), 1002, Color.BLACK, "06SD456");
        carWork.setId(ID);
        carWork.setName("car");
        carWork.setCode(CODE + "2333");

    }

    private Optional<Car> readAnyCar() {
        Page<Car> page = carRepository.findAll(PageRequest.of(0, 1));
        if (page.getTotalElements() > 0) {
            return Optional.of(page.getContent().get(0));
        }
        return Optional.empty();
    }

    @Test
    public void testFindById() {

        readAnyCar().ifPresent(p -> {
            Optional<Car> car = carService.findById(p.getId());
            assertThat(car.get().getCode()).isEqualTo(p.getCode());
        });
    }

    @Test
    public void testSave() {
        carWork.setId(null);
        readAnyCar().ifPresent(p -> {
            carWork.setModel(p.getModel());

            Car car = carService.create(carWork);

            assertThat(car).isEqualTo(carWork);
        });
    }

    @Test
    public void testUpdate() {
        readAnyCar().ifPresent(p -> {
            p.setCode("newCode");
            Car car = carService.update(p);
            assertThat(car.getCode()).isEqualTo(p.getCode());
        });
    }

    @Test
    public void testFindByCode() {
        Car car = carService.findByCode(CODE).orElse(new Car());
        assertThat(car.getCode()).isEqualTo(CODE);

    }

    @Test
    public void testFindByAll() {


        Page<Car> carPage = carService.findAll(PageRequest.of(0, 1));
        assertThat(carPage).isNotNull();

    }


}
