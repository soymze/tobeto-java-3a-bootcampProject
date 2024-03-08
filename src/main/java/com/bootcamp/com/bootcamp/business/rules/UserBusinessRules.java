package com.bootcamp.com.bootcamp.business.rules;

import com.bootcamp.com.bootcamp.core.exceptions.types.BusinessException;
import com.bootcamp.com.bootcamp.dataAccess.UserRepository;
import com.bootcamp.com.bootcamp.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfMailExists(String mail){
        User user = userRepository.getByEmail(mail.trim());
        if(user != null){
            throw new BusinessException("This mail has been registered before.");
        }
    }
}
