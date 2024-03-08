package com.bootcamp.com.bootcamp.business.requests.create.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateInstructorRequest {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String companyName;
    private String mail;
}
