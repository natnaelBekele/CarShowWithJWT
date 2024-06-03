package com.binary.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String role;

}
