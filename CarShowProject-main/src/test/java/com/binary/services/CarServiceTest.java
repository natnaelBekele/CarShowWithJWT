package com.binary.services;

import com.binary.entities.Car;
import com.binary.repositories.CarRepository;
import com.binary.repositories.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Mock
    private OwnerRepository ownerRepository;



    @Test
    @DisplayName("Car service get all cars success")
    public void carService_getAllCars_success(){

        List<Car> cars =  new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());

        Mockito.when(carRepository.findAll()).thenReturn(cars);

        List<Car> result = carService.getAllCars();

        Assertions.assertEquals(cars.size(), result.size());


    }










}
