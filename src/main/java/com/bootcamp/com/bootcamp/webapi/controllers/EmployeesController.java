package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.EmployeeService;
import com.bootcamp.com.bootcamp.business.requests.create.employee.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping()
    public CreateEmployeeResponse create(@RequestBody CreateEmployeeRequest request){
        CreateEmployeeResponse result = employeeService.create(request);
        return result;
    }
    @GetMapping("getallEmployees")
    public List<GetAllEmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("getbyid/{id}")
    public GetEmployeeResponse getById(@PathVariable int id){
        return employeeService.getById(id);
    }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee inputEmployee, @PathVariable("id") int id) {
        return employeeService.updateEmployee(inputEmployee, id);
    }
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
        return "Deleted Successfully";
    }

    @GetMapping("getbyposition/{position}")
    public GetByPosition getByPosition(@PathVariable String position){
        return employeeService.getByPosition(position);
    }
}
