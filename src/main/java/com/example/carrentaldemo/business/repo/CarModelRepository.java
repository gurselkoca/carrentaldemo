package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "carmodel", path = "carmodel")
@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

}
