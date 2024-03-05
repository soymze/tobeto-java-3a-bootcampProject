package com.bootcamp.com.bootcamp.business.requests.create;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String position;
}
