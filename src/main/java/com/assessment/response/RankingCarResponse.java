package com.assessment.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RankingCarResponse {
    private String name;
    private String brand;
    private Date year;
    private Double csFuelCityKML;
    private Double csFuelHighwaysKML;
    private Double totalKMCity;
    private Double totalKMHways;

    @JsonCreator
    public RankingCarResponse(
            @JsonProperty("name") String name,
            @JsonProperty("brand") String brand,
            @JsonProperty("year") Date year,
            @JsonProperty("csFuelCityKML") Double csFuelCityKML ,
            @JsonProperty("csFuelHighwaysKML") Double csFuelHighwaysKML,
            @JsonProperty("totalKMCity") Double totalKMCity,
            @JsonProperty("totalKMHways") Double totalKMHways,
            @JsonProperty("gasolPrice") Double gasolPrice
        ) 
    {
        this.setName(name);
        this.setBrand(brand);
        this.year = year;
        this.csFuelCityKML = csFuelCityKML;
        this.csFuelHighwaysKML = csFuelHighwaysKML;
        this.totalKMCity = totalKMCity* csFuelCityKML*gasolPrice;
        this.totalKMHways = totalKMHways* csFuelHighwaysKML*gasolPrice;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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


    public Double getTotalKMCity() {
        return totalKMCity;
    }


    public void setTotalKMCity(Double totalKMCity) {
        this.totalKMCity = totalKMCity;
    }


    public Double getTotalKMHways() {
        return totalKMHways;
    }


    public void setTotalKMHways(Double totalKMHways) {
        this.totalKMHways = totalKMHways;
    }
}
