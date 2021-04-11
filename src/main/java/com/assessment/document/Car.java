package com.assessment.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "cars")
public class Car {
    @Id
    private String id;

    @Field("name")
    @Indexed(unique = true)
    private String name;

    @Field("model")
    @Indexed(unique = true)
    private String model;

    @Field("brand")
    private String brand;

    @Field("year")
    private Date year;

    /*cs = consumption  */
    @Field("cs_fuel_city_km_l")
    private Double csFuelCityKML;

    /*cs = consumption  */
    @Field("cs_fuel_highways_km_l")
    private Double csFuelHighwaysKML;

    public Car(String name, String model, String brand, Date year, Double csFuelCityKML, Double csFuelHighwaysKML) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.csFuelCityKML = csFuelCityKML;
        this.csFuelHighwaysKML = csFuelHighwaysKML;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}