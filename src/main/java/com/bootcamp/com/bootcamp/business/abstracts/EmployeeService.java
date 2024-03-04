package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    CreateEmployeeResponse create(CreateEmployeeRequest request);
    List<GetAllEmployeeResponse> getAll();
    GetEmployeeResponse getById(int id);
}
