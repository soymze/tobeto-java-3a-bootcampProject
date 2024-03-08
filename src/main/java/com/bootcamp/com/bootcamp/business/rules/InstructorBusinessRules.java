package com.bootcamp.com.bootcamp.business.rules;

import com.bootcamp.com.bootcamp.core.exceptions.types.BusinessException;
import com.bootcamp.com.bootcamp.dataAccess.InstructorRepository;
import com.bootcamp.com.bootcamp.entities.Instructor;
import com.bootcamp.com.bootcamp.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class InstructorBusinessRules {
    @Autowired
    private InstructorRepository instructorRepository;

    public void checkIfMailExists(String email){
        Instructor instructor = (Instructor) instructorRepository.getByEmail(email.trim());
        if(instructor != null){
            throw new BusinessException("This mail has been registered before.");
        }
    }
}
