package com.bootcamp.com.bootcamp.business.responses.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
}
