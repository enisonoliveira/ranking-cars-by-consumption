package com.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assessment.document.Car;
import com.assessment.request.CarRequest;
import com.assessment.response.RankingCarResponse;
import com.assessment.service.CarsService;
import com.google.gson.Gson;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping (path = "/raking/car")
public class RankingCarController {
    
    Logger logger = LoggerFactory.getLogger( RankingCarController.class);

    @Autowired
    private CarsService carsService;

    @PostMapping (value = "/save")
    @ResponseStatus ( HttpStatus.OK)
    public ResponseEntity<String> saveCar
        (  
            @RequestBody
            @Valid CarRequest request
        )   throws Exception
    {
        logger.info(request.getCsFuelHighwaysKML().toString());
        Car car= carsService.saveConverter(request);
       
        Gson gson = new Gson ( );
        
        String jsonString= gson .toJson( new RankingCarResponse
                            (   
                                car.getName(), 
                                car.getBrand(), 
                                car.getYear(),
                                car.getCsFuelCityKML()
                                ,car.getCsFuelHighwaysKML(), 1.0,1.0,1.0
                            )
        );
        
        return ResponseEntity
        .status( HttpStatus.CREATED)
        .header("X-Reason", "ok")
        .body(jsonString);
    }

    @GetMapping (value = "/ranking")
    @ResponseStatus ( HttpStatus.OK)
    public ResponseEntity<String> rankingList
        (  
            @RequestParam    Double totalKMCity,
            @RequestParam    Double totalKMHways,
            @RequestParam    Double gasolPrice
        )   throws Exception
    {
        List<RankingCarResponse> colResponse;
        colResponse= carsService.rankingList(totalKMCity,totalKMHways,gasolPrice);
        
        Gson gson = new Gson ( );
       
        return ResponseEntity
        .status( HttpStatus.CREATED)
        .header("X-Reason", "ok")
        .body(gson.toJson(colResponse));
    }
}
