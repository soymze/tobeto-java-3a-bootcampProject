package com.bootcamp.com.bootcamp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicants")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Applicant extends User{

    @Column(name = "about")
    private String about;
}
