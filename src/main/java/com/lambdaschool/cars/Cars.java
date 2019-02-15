package com.lambdaschool.cars;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Cars
{
    private @Id @GeneratedValue Long id;
//    private String cars;
    private Long year;
    private String brand;
    private String model;

    public Cars()
    {
        //default constructor
    }

    public Cars (Long year, String brand, String model)
    {
//        this.cars = cars;
        this.year = year;
        this.brand = brand;
        this.model = model;
    }



}
