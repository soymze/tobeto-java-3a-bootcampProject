package com.bootcamp.com.bootcamp.business.rules;

import com.bootcamp.com.bootcamp.core.exceptions.types.BusinessException;
import com.bootcamp.com.bootcamp.dataAccess.ApplicantRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantBusinessRules {
    @Autowired
    private ApplicantRepository applicantRepository;

    public void checkIfMailExists(String email){
        Applicant applicant = applicantRepository.getByEmail(email.trim());
        if(applicant != null){
            throw new BusinessException("This mail has been registered before.");
        }
    }
}
