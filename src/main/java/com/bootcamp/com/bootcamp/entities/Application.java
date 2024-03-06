package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


public class Application {

    @Column(name = "applicationId")
    private int id;
    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private int bootcamp_id;
    @ManyToOne
    @JoinColumn(name = "applicationStateId")
    private int applicationState_id;
}
