package com.bootcamp.com.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="instructors")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Instructor extends User{

    @Column(name = "companyName")
    private String companyName;


}
