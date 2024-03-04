package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;

import java.util.List;

public interface ApplicantService {

    CreateApplicantResponse create(CreateApplicantRequest request);
    List <GetAllApplicantResponse> getAll();
    GetApplicantResponse getById(int id);
}
