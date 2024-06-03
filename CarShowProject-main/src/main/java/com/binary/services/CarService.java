package com.binary.services;

import com.binary.dtos.CarDto;
import com.binary.entities.Car;
import org.hibernate.sql.Update;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars();
    public Car  createCar(CarDto car);
    public Car updateCar(long id, Car updatedCar);
    public long deleteCar(long id);
    public Car getCarById(long id);
}
