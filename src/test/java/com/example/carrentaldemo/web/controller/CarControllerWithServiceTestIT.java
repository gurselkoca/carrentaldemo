package com.example.carrentaldemo.web.controller;

import com.example.carrentaldemo.business.domain.Car;
import com.example.carrentaldemo.business.domain.CarModel;
import com.example.carrentaldemo.business.domain.Color;
import com.example.carrentaldemo.business.utils.RestResponsePage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@AutoConfigureMockMvc
public class CarControllerWithServiceTestIT {
    @Autowired
    private MockMvc mockMvc;


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
        carWork.setCode(CODE + "2333");
    }

    private Optional<Car> readAnyCar() throws Exception {
        PageRequest pageable = PageRequest.of(0, 1);
        String result = mockMvc.perform(get(URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pageable)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Page<Car> page = objectMapper.readValue(result, new TypeReference<RestResponsePage<Car>>() {
        });
        if (page.getTotalElements() > 0) {
            return Optional.of(page.getContent().get(0));
        }
        return Optional.empty();
    }


    @Test
    public void testfindAll() throws Exception {
        PageRequest pageable = PageRequest.of(0, 1);

        String result = mockMvc.perform(get(URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pageable)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Page<Car> carPage = objectMapper.readValue(result, RestResponsePage.class);
        assertThat(carPage).isNotNull();
        //assertThat(result).isEqualToIgnoringCase(objectMapper.writeValueAsString(page));
    }


    @Test
    public void testFindById() throws Exception {
        readAnyCar().ifPresent(p -> {
            try {

                String result = mockMvc.perform(get(URL + "/{id}", p.getId())
                        .contentType("application/json"))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
                Car car = objectMapper.readValue(result, Car.class);
                assertThat(car).isEqualTo(p);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testCreate() throws Exception {
        carWork.setId(null);
        readAnyCar().ifPresent(p -> {
            try {

                carWork.setModel(p.getModel());
                String result = mockMvc.perform(post(URL)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(carWork)))
                        .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
                Car car = objectMapper.readValue(result, Car.class);
                assertThat(car.getCode()).isEqualTo(carWork.getCode());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testUpdate() throws Exception {
        readAnyCar().ifPresent(p -> {
            try {
                p.setCode("newCode");
                String result = mockMvc.perform(patch(URL)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(p)))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
                Car car = objectMapper.readValue(result, Car.class);
                assertThat(car.getCode()).isEqualTo(p.getCode());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testFindByCode() throws Exception {
        readAnyCar().ifPresent(p -> {
            try {

                String result = mockMvc.perform(get(URL)
                        .contentType("application/json")
                        .param("code", p.getCode()))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
                Car car = objectMapper.readValue(result, Car.class);
                assertThat(car).isEqualTo(p);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }


}
