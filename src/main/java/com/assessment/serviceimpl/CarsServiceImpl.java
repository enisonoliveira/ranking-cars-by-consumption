package com.assessment.serviceimpl;

import java.util.List;

import com.assessment.document.Car;

public interface CarsServiceImpl {

    public Car save( Car car) throws  Exception ;

     List < Car > findAll (  );
}
