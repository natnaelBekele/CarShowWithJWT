package com.binary.repositories;

import com.binary.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CarRepository extends CrudRepository<Car, Long> {

    // count()  => returns the number of entities
    // findALl() => returns all items of given type
    // findByID() => returns one item by ID
    // delete(T Entyity) => Delete an Entity
    // deleteAll() => deletes all the entities in the repository
    // save(T Entity) => saves an Entity
    //  saveAll(); saves all the entities in the repository
}
