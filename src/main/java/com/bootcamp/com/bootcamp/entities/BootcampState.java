package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcampStates")
@Builder
public class BootcampState {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "bootcampState")
    private List<Bootcamp> bootcamps;
}
