package com.binary.services;

import com.binary.dtos.CarDto;
import com.binary.entities.Car;
import com.binary.exceptions.CarNotFoundException;
import com.binary.repositories.CarRepository;
import com.binary.repositories.OwnerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car createCar(CarDto cardto) {


        if(cardto.getOwner() != null && cardto.getOwner().getOwnerId() == null){
                ownerRepository.save(cardto.getOwner());
        }

        Car car = new Car();
        car.setBrand(cardto.getBrand());
        car.setModel(cardto.getModel());
        car.setColor(cardto.getColor());
        car.setYear(cardto.getYear());
        car.setRegisterNumber(cardto.getRegisterNumber());
        car.setPrice(cardto.getPrice());
        car.setOwner(cardto.getOwner());

       Car savedCar = carRepository.save(car);

        return savedCar;
    }




    @Override
    public Car updateCar(long id, Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent()){
            if(updatedCar.getBrand() != null)
            optionalCar.get().setBrand(updatedCar.getBrand());
            if(updatedCar.getModel() != null)
            optionalCar.get().setModel(updatedCar.getModel());
            if(updatedCar.getColor() != null)
            optionalCar.get().setColor(updatedCar.getColor());
            if(updatedCar.getPrice() > 0)
            optionalCar.get().setPrice(updatedCar.getPrice());
            if(updatedCar.getYear() > 0)
            optionalCar.get().setYear(updatedCar.getYear());
            if(updatedCar.getOwner() != null)
            optionalCar.get().setOwner(updatedCar.getOwner());

            carRepository.save(optionalCar.get());
            return  optionalCar.get();
        } else{
            throw new CarNotFoundException("Requested car with id: " + id +  " does not exit in our system");
        }

    }


    @Override
    public long deleteCar(long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()){
            carRepository.deleteById(id);
            return  id;
        }else{
            throw new CarNotFoundException("Requested car with id: " + id +  " does not exit in our system");
        }
    }



    @Override
    public Car getCarById(long id) throws CarNotFoundException{
        Optional<Car> car = carRepository.findById(id);
          if(car.isEmpty()){
              throw new CarNotFoundException("Requested car with id: " + id +  " does not exit in our system");
          }
          return car.get();
    }
}
