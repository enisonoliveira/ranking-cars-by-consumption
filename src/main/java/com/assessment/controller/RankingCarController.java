package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.service.CarsService;;

@RestController
@RequestMapping (path = "/raking")
public class RankingCarController {
    

    @Autowired
    private CarsService carsService;

    

}
