package com.bootcamp.com.bootcamp.business.responses.get.applicant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetApplicantResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String about;
}
