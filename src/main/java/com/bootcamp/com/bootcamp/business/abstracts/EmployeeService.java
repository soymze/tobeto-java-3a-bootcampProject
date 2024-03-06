package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.employee.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.Employee;

import java.util.List;

public interface EmployeeService {

    DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest request);
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> getById(int id);
    DataResult<Employee> updateEmployee(Employee employee, int id);
    DataResult<?> deleteEmployeeById(int id);
    DataResult<GetByPosition> getByPosition(String position);
}
