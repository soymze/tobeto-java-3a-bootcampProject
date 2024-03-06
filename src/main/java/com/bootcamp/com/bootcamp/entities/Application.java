package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applications")
public class Application {
    @Id
    @Column(name = "applicationId")
    private int id;
    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;
    @ManyToOne
    @JoinColumn(name = "applicationStateId")
    private ApplicationState applicationState;
}
