package com.binary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;
    private String firstname, lastname;
    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Car> cars;


    public Owner(){

    }

    public Owner( String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cars=" + cars +
                '}';
    }
}
