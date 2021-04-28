package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.Brand;
import com.example.carrentaldemo.business.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
