package com.bootcamp.com.bootcamp.business.responses.create.applicant;

import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.ApplicationState;
import com.bootcamp.com.bootcamp.entities.Bootcamp;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicantResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String about;
    private String email;
}
