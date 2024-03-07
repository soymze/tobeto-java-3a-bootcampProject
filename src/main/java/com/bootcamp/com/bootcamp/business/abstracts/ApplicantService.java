package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.applicant.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetByAbout;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.Applicant;

import javax.xml.crypto.Data;
import java.util.List;

public interface ApplicantService {

    DataResult<CreateApplicantResponse> create(CreateApplicantRequest request);
    DataResult<List <GetAllApplicantResponse>> getAll();
    DataResult<GetApplicantResponse> getById(int id);
    DataResult<Applicant> updateApplicant(Applicant applicant, int id);
    DataResult<?> deleteApplicantById(int id);
    DataResult<GetByAbout> getByAbout(String about);
    DataResult<List<GetAllApplicantResponse>> getAllPage(PageDto pageDto);
}
