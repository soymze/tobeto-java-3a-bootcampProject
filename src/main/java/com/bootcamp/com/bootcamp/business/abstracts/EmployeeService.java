package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetByAbout;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Employee;

import java.util.List;

public interface EmployeeService {

    CreateEmployeeResponse create(CreateEmployeeRequest request);
    List<GetAllEmployeeResponse> getAll();
    GetEmployeeResponse getById(int id);
    Employee updateEmployee(Employee employee, int id);
    void deleteEmployeeById(int id);
    GetByPosition getByPosition(String position);
}
