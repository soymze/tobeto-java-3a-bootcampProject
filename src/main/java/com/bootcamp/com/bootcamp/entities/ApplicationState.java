package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicationStates")
public class ApplicationState {
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
