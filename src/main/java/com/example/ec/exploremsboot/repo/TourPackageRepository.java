package com.example.ec.exploremsboot.repo;

import com.example.ec.exploremsboot.domain.TourPackage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    Optional<TourPackage> findByName(String name);

//    @Query("Select tp from TourPackage tp where tp.name = ?1")
//    Optional<TourPackage> findByName(String name);
}
