package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.EmployeeService;
import com.bootcamp.com.bootcamp.business.requests.create.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.dataAccess.EmployeeRepository;
import com.bootcamp.com.bootcamp.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {
        Employee employee = mapperService.forRequest().map(request, Employee.class);
        employeeRepository.save(employee);

        CreateEmployeeResponse response = mapperService.forResponse()
                .map(employee, CreateEmployeeResponse.class);
        return response;
    }

    @Override
    public List<GetAllEmployeeResponse> getAll() {

        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeResponses =
                employees.stream().map(employee -> mapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
                        .collect(Collectors.toList());
        return employeeResponses;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id);
        GetEmployeeResponse response =
                mapperService.forResponse().map(employee, GetEmployeeResponse.class);
        return response;
    }

}
