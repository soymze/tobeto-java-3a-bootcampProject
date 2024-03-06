package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicationStates")
public class ApplicationState {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "applicationState")
    private List<Application> applications;
}
