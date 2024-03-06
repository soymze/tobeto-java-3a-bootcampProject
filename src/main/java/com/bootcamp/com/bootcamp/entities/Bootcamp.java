package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcamps")
public class Bootcamp {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;
    @Column(name = "startDate")
    private LocalDateTime startDate;
    @Column(name = "endDate")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "bootcampStateId")
    private BootcampState bootcampState;
    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;
}
