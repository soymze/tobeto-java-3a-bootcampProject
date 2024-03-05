package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetByAbout;
import com.bootcamp.com.bootcamp.entities.Applicant;

import java.util.List;

public interface ApplicantService {

    CreateApplicantResponse create(CreateApplicantRequest request);
    List <GetAllApplicantResponse> getAll();
    GetApplicantResponse getById(int id);
    Applicant updateApplicant(Applicant applicant, int id);
    void deleteApplicantById(int id);
    GetByAbout getByAbout(String about);
}
