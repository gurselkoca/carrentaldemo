package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
