package com.assessment.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CarRequest {

    @NotBlank
    private String name;
    private String brand;
    private String model;
    private Date year;
    private Double csFuelCityKML;
    private Double csFuelHighwaysKML;

    @JsonCreator
    public CarRequest(
            @JsonProperty("name")  String name,
            @JsonProperty("model")  String model,
            @JsonProperty("brand")  String brand,
            @JsonProperty("year")   Date year,
            @JsonProperty("csFuelCityKML")  Double csFuelCityKML ,
            @JsonProperty("csFuelHighwaysKML") Double csFuelHighwaysKML
        ) 
    {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.csFuelCityKML = csFuelCityKML;
        this.csFuelHighwaysKML = csFuelHighwaysKML;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Double getCsFuelCityKML() {
        return csFuelCityKML;
    }

    public void setCsFuelCityKML(Double csFuelCityKML) {
        this.csFuelCityKML = csFuelCityKML;
    }

    public Double getCsFuelHighwaysKML() {
        return csFuelHighwaysKML;
    }

    public void setCsFuelHighwaysKML(Double csFuelHighwaysKML) {
        this.csFuelHighwaysKML = csFuelHighwaysKML;
    }

}