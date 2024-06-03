package com.binary;

import com.binary.entities.Car;
import com.binary.entities.Member;
import com.binary.entities.Owner;
import com.binary.repositories.CarRepository;
import com.binary.repositories.OwnerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;


	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


		Owner owner1 = new Owner("nat", "sy");
		Owner owner2 = new Owner("kim", "sy");
		Owner owner3 = new Owner("jim", "sy");
		Owner owner4 = new Owner("roy", "sy");

		Car car1 = new Car("Ford", "Mustand", "red", "xyz", 2024,56000,owner1);
		Car car2 = new Car("Nissan", "Leaf", "green", "anything", 2021,19500, owner2);
		Car car3 = new Car("Toyota", "Camry", "blue", "something", 2023,32000, owner2);
		Car car4 = new Car("Lexus", "ES 350", "white", "number", 2020,59000, owner4);


		ownerRepository.save(owner1);
		ownerRepository.saveAll(Arrays.asList(owner2,owner3,owner4));
		carRepository.save(car1);
		carRepository.saveAll(Arrays.asList(car2,car3,car4));

		// Fetch all cars and print to console.
		carRepository.findAll().forEach(car -> System.out.println(car));

	}
}
