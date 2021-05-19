package com.example.carrentaldemo.business.repo;


import com.example.carrentaldemo.business.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "rent", path = "rent")
@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}
