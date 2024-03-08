package com.bootcamp.com.bootcamp.business.requests.create.instructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateInstructorRequest {
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
    @NotEmpty(message = "Company name can not be empty.")
    @Size(min = 3,message = "Company name can be minimum 3 characters.")
    private String companyName;
    @NotEmpty(message = "Mail can not be empty.")
    @Size(min = 3,message = "Mail can be minimum 13 characters.")
    private String email;
}
