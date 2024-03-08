package com.bootcamp.com.bootcamp.business.requests.create.applicant;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicantRequest {
    private int id;

    @NotEmpty(message = "Username can not be empty.")
    @Size(min = 3,message = "Username can be minimum 3 characters.")
    private String username;

    @NotEmpty(message = "Name can not be empty.")
    @Size(min = 3,message = "Name can be minimum 3 characters.")
    private String firstName;

    @NotEmpty(message = "Surname can not be empty.")
    @Size(min = 3,message = "Surname can be minimum 3 characters.")
    private String lastName;

    @NotEmpty(message = "About can not be empty.")
    @Size(min = 3,message = "About can be minimum 50 characters.")
    private String about;

    @NotEmpty(message = "Mail can not be empty.")
    @Size(min = 3,message = "Mail can be minimum 13 characters.")
    private String email;
}
