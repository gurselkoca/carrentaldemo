package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.Brand;
import com.example.carrentaldemo.business.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "carmodel", path = "carmodel")
public interface CarModelRepository extends JpaRepository<CarModel,Long> {

}
