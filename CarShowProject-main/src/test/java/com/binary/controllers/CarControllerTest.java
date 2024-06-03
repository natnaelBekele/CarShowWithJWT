package com.binary.controllers;


import com.binary.dtos.CarDto;
import com.binary.entities.Car;
import com.binary.services.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
       @InjectMocks
       private CarController carController;
       @Mock
       private CarServiceImpl carServiceImpl;


      @Test
      @DisplayName("Car controller get all cars success test case")
      public void carController_getAllCars_success(){
          List<Car> expectedCars = new ArrayList<Car>();
          Car car = new Car();
          car.setId(1L);
          car.setPrice(25000);
          car.setModel("sdfghj");
          expectedCars.add(car);
          expectedCars.add(new Car());

          Mockito.when(carServiceImpl.getAllCars()).thenReturn(expectedCars);

          ResponseEntity<List<Car>> result = carController.getAllCars();

          Assertions.assertEquals(2,result.getBody().size());
          Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

      }


     @Test
     @DisplayName("Car controller get car by ID success test case")
     public void carController_getCarById_success(){

          Car requestedCar = new Car();
              requestedCar.setId(2L);

          long expectedCarID = 2;

          Mockito.when(carServiceImpl.getCarById(expectedCarID)).thenReturn(requestedCar);

          ResponseEntity<Car> result = carController.getCarById(expectedCarID);


          Assertions.assertEquals(expectedCarID, result.getBody().getId());
          Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

     }


     @Test
     @DisplayName("Car controller createCar success test case")
     public void carController_createCar_success(){

            CarDto carBeforeCreated = new CarDto();
            carBeforeCreated.setModel("xyz");


            Car createdCar = new Car();
            createdCar.setId(1L);
            createdCar.setModel(carBeforeCreated.getModel());


            Mockito.when(carServiceImpl.createCar(Mockito.any())).thenReturn(createdCar);

            ResponseEntity<Car> result = carController.createCar(carBeforeCreated);


            Assertions.assertEquals(carBeforeCreated.getModel(), result.getBody().getModel());
            Assertions.assertNotNull(result.getBody().getId());
            Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

     }


     @Test
     @DisplayName("Car controller update Car success test case")
    public void carController_updateCar_success(){

          Car updates = new Car();
         updates.setYear(2020);
         updates.setColor("green");

          long carIdThatNeedToBeUpdated = 45;

          Car updatedCar = new Car();
          updatedCar.setId(carIdThatNeedToBeUpdated);
          updatedCar.setColor(updates.getColor());
          updatedCar.setYear(updates.getYear());

          Mockito.when(carServiceImpl.updateCar(carIdThatNeedToBeUpdated, updates )).thenReturn(updatedCar);
         ResponseEntity<Car> result = carController.updateCar(carIdThatNeedToBeUpdated, updates);

         Assertions.assertEquals(updatedCar.getYear(), result.getBody().getYear());
         Assertions.assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
         Assertions.assertEquals(carIdThatNeedToBeUpdated, result.getBody().getId());

     }


    @Test
    @DisplayName("Car controller delete Car success test case")
    public void  carController_deleteCar_success(){
        long carIdThatNeedToBeDeleted = 45;

        Mockito.when(carServiceImpl.deleteCar(carIdThatNeedToBeDeleted)).thenReturn(carIdThatNeedToBeDeleted);

        ResponseEntity<Long> result = carController.deleteCar(carIdThatNeedToBeDeleted);

        Assertions.assertEquals(carIdThatNeedToBeDeleted, result.getBody());
        Assertions.assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());


    }












}
