package com.assessment.serviceimpl;

import java.util.List;

import com.assessment.document.Car;
import com.assessment.response.RankingCarResponse;

import org.springframework.data.domain.Sort;

public interface CarsServiceImpl {

    public Car save( Car car) throws  Exception ;

     List < Car > findAll (  );

     public List<RankingCarResponse> rankingList
     (
         double totalKMCity,
         double totalKMHways,
         double gasolPrice
     )   throws Exception;

     public boolean validateDataSearch
    (
        double totalKMCity,
        double totalKMHways,
        double gasolPrice
    )   throws Exception;

    public void deleteAll ();

    public boolean findByName( String name );

    public Sort sortByIdAsc();

    public List<Car>gasolRankingCar( List<Car> colCar);
    
}
