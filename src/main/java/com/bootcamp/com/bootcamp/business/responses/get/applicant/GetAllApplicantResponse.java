package com.bootcamp.com.bootcamp.business.responses.get.applicant;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicantResponse {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
}
