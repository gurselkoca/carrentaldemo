package com.example.carrentaldemo.web.controller;

import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Page<Car> findAll(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @PatchMapping
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @GetMapping(params = {"code"})
    public Car findByCode(@RequestParam String code) {
        return carService.findByCode(code).get();
    }

    @GetMapping(path = "/{id}")
    public Car findById(@PathVariable Long id) {
        return carService.findById(id).get();
    }
}
