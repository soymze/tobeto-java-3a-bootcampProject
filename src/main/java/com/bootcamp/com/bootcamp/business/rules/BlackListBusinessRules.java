package com.bootcamp.com.bootcamp.business.rules;

import com.bootcamp.com.bootcamp.core.exceptions.types.BusinessException;
import com.bootcamp.com.bootcamp.dataAccess.BlackListRepository;
import com.bootcamp.com.bootcamp.entities.BlackList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BlackListBusinessRules {
    private BlackListRepository blackListRepository;

    public void checkIfApplicantInBlackList(int id){
        BlackList blackList = blackListRepository.getByApplicantId(id);
        if(blackList != null){
            throw new BusinessException("Applicant in the Blacklist!");
        }
    }
}
