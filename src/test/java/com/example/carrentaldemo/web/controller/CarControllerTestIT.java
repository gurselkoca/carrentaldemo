package com.example.carrentaldemo.web.controller;

import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.domain.CarModel;
import com.example.carrentaldemo.business.domain.Color;
import com.example.carrentaldemo.business.service.impl.CarServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CarServiceImpl carService;


    @Autowired
    private ObjectMapper objectMapper;


    Car carWork;

    private final static Long ID = 1L;
    private final static String CODE = "C1";

    private final static String URL = "/cars";

    @BeforeEach
    void init() {
        assertThat(mockMvc).isNotNull();
        assertThat(objectMapper).isNotNull();
        //   carService = new CarServiceImpl(carService);
        carWork = new Car(new CarModel(), 1002, Color.BLACK, "06SD456");
        carWork.setId(ID);
        carWork.setName("car");
        carWork.setCode(CODE);
    }

    @Test
    public void testfindAll() throws Exception {
        PageImpl<Car> page = new PageImpl<>(Lists.list(carWork));
        PageRequest pageable = PageRequest.of(0, 1);
        when(carService.findAll(any(PageRequest.class))).thenReturn(page);
        String result = mockMvc.perform(get(URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pageable)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        //Page<Car> carPage = objectMapper.readValue(result,PageImpl.class);
        assertThat(result).isEqualToIgnoringCase(objectMapper.writeValueAsString(page));
    }


    @Test
    public void testFindById() throws Exception {
        when(carService.findById(ID)).thenReturn(Optional.of(carWork));

        String result = mockMvc.perform(get(URL + "/{id}", ID)
                .contentType("application/json"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Car car = objectMapper.readValue(result, Car.class);
        assertThat(car).isEqualTo(carWork);
    }

    @Test
    public void testCreate() throws Exception {
        when(carService.create(any(Car.class))).thenReturn(carWork);
        String result = mockMvc.perform(post(URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carWork)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        Car car = objectMapper.readValue(result, Car.class);
        assertThat(car).isEqualTo(carWork);

    }

    @Test
    public void testUpdate() throws Exception {
        when(carService.update(any(Car.class))).thenReturn(carWork);
        String result = mockMvc.perform(patch(URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carWork)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Car car = objectMapper.readValue(result, Car.class);
        assertThat(car).isEqualTo(carWork);
    }

    @Test
    public void testFindByCode() throws Exception {
        when(carService.findByCode(CODE)).thenReturn(Optional.of(carWork));

        String result = mockMvc.perform(get(URL)
                .contentType("application/json")
                .param("code", CODE))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Car car = objectMapper.readValue(result, Car.class);
        assertThat(car).isEqualTo(carWork);


    }


}
