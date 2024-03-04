package com.bootcamp.com.bootcamp.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {

    private int id;
    private String firstName;
    private String userName;
}
