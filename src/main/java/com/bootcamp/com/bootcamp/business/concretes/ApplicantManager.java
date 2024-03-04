package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.ApplicantService;
import com.bootcamp.com.bootcamp.business.requests.create.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.dataAccess.ApplicantRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService mapperService;

    @Override
    public CreateApplicantResponse create(CreateApplicantRequest request) {
        Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse()
                .map(applicant, CreateApplicantResponse.class);
        return response;
    }

    @Override
    public List<GetAllApplicantResponse> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();
        List<GetAllApplicantResponse> applicantResponses =
                applicants.stream().map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
                        .collect(Collectors.toList());
        return applicantResponses;
    }

    @Override
    public GetApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id);
        GetApplicantResponse response =
                mapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return response;
    }
}
