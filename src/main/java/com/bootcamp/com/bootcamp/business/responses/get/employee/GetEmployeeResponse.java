package com.bootcamp.com.bootcamp.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetEmployeeResponse {
    private int id;
    private String firstName;
    private String userName;
}
