package com.lambdaschool.cars;

public class CarsNotFoundException extends RuntimeException
{
    public CarsNotFoundException (Long id)
    {
        super("Could not find the car you were looking for...");
    }
}
