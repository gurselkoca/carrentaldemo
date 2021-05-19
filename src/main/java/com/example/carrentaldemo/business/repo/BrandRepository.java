package com.example.carrentaldemo.business.repo;

import com.example.carrentaldemo.business.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "brand", path = "brand")
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
