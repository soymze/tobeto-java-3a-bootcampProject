package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcamps")
public class Bootcamp {
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "instructorId")
    private int instructor_id;
    @Column(name = "startDate")
    private LocalDateTime startDate;
    @Column(name = "endDate")
    private LocalDateTime endDate;
    @Column(name = "bootcampStateId")
    private int bootcampState_id;
}
