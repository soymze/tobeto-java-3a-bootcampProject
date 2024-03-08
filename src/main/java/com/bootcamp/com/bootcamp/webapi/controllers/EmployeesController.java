package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.EmployeeService;
import com.bootcamp.com.bootcamp.business.requests.create.employee.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController extends BaseController{

    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateEmployeeRequest request){
        return handleDataResult(employeeService.create(request));
    }
    @GetMapping("getallEmployees")
    public ResponseEntity<?> getAll(){
        return handleDataResult(employeeService.getAll());
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(employeeService.getById(id));
    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee inputEmployee, @PathVariable("id") int id) {
        return handleDataResult(employeeService.updateEmployee(inputEmployee, id));
    }
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id){
        return handleDataResult(employeeService.deleteEmployeeById(id));
    }
    @GetMapping("getbyposition/{position}")
    public ResponseEntity<?> getByPosition(@PathVariable String position){
        return handleDataResult(employeeService.getByPosition(position));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(employeeService.getAllPage(pageDto));
    }
}
