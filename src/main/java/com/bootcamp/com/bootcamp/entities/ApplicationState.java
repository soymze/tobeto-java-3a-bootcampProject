package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


public class ApplicationState {
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
