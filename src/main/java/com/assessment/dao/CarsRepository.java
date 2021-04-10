package com.assessment.dao;

import java.util.List;
import java.util.Optional;

import com.assessment.document.Car;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CarsRepository extends MongoRepository < Car, String > {

    @Query("{'name' :  ?0}")
    Optional<Car> findByName(String name);
}