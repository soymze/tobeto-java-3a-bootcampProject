package com.bootcamp.com.bootcamp.business.responses.get.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicantResponse {

    private int id;
    private String firstName;
    private String userName;
}
