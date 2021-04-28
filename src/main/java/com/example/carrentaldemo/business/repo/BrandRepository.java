package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "brand", path = "brand")
public interface BrandRepository extends JpaRepository<Brand,Long> {

}
