package com.example.carrentaldemo.business.repo;


import com.example.carrentaldemo.business.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "rent", path = "rent")
public interface RentRepository extends JpaRepository<Rent,Long> {

}
