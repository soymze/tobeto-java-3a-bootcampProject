package com.bootcamp.com.bootcamp.business.responses.create.applicant;

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
}
