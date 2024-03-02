package com.bootcamp.com.bootcamp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthDate")
    private String dateOfBirth;
    @Column(name = "identity")
    private String nationalIdentity;
    @Column(name = "mail")
    private String email;
    @Column(name = "password")
    private String password;


}
