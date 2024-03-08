package com.bootcamp.com.bootcamp.business.rules;

import com.bootcamp.com.bootcamp.core.exceptions.types.BusinessException;
import com.bootcamp.com.bootcamp.dataAccess.EmployeeRepository;
import com.bootcamp.com.bootcamp.entities.Employee;
import com.bootcamp.com.bootcamp.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBusinessRules {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void checkIfMailExists(String email){
        Employee employee = (Employee) employeeRepository.getByEmail(email.trim());
        if(employee != null){
            throw new BusinessException("This mail has been registered before.");
        }
    }
}
