package com.bootcamp.com.bootcamp.business.responses.create.application;

import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.ApplicationState;
import com.bootcamp.com.bootcamp.entities.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationResponse {
    private int id;
    private Applicant applicant;
    private Bootcamp bootcamp;
    private ApplicationState applicationState;
}
