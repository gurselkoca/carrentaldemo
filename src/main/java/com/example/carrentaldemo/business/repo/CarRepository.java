package com.example.carrentaldemo.business.repo;


import com.example.carrentaldemo.business.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@RepositoryRestResource(collectionResourceRel = "car", path = "car")
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByCode(String code);


}
