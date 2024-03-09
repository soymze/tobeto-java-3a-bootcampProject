package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.ApplicantService;
import com.bootcamp.com.bootcamp.business.constants.ApplicantMessages;
import com.bootcamp.com.bootcamp.business.requests.create.applicant.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetByAbout;
import com.bootcamp.com.bootcamp.business.rules.ApplicantBusinessRules;
import com.bootcamp.com.bootcamp.core.aspects.logging.Loggable;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.ApplicantRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService mapperService;
    private ApplicantBusinessRules applicantBusinessRules;

    @Override
    public DataResult<CreateApplicantResponse> create(CreateApplicantRequest request) {
        applicantBusinessRules.checkIfMailExists(request.getEmail());
        Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse()
                .map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<CreateApplicantResponse>(response, ApplicantMessages.ApplicantAdded);
    }

    @Override
    @Loggable
    public DataResult<List<GetAllApplicantResponse>> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();
        List<GetAllApplicantResponse> applicantResponses =
                applicants.stream().map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicantResponse>>(applicantResponses,ApplicantMessages.ApplicantListed);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant applicant = applicantRepository.findById(id);
        GetApplicantResponse response =
                mapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(response,ApplicantMessages.ApplicantListed);
    }

    @Override
    public DataResult<Applicant> updateApplicant(Applicant inputApplicant, int id) {
        Applicant appDB = applicantRepository.findById(id);
        appDB.setFirstName(inputApplicant.getFirstName());
        applicantRepository.save(appDB);
        return new SuccessDataResult<Applicant>(appDB,ApplicantMessages.ApplicantUpdated);
    }

    @Override
    public DataResult<?> deleteApplicantById(int id) {
        applicantRepository.deleteById(id);
        return new SuccessDataResult<>(null,ApplicantMessages.ApplicantDeleted);
    }
    @Override
    public DataResult<GetByAbout> getByAbout(String about) {
        Applicant applicant = applicantRepository.findByAbout(about);
        GetByAbout response =
                mapperService.forResponse().map(applicant, GetByAbout.class);
        return new SuccessDataResult<GetByAbout>(response,ApplicantMessages.ApplicantListed);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Applicant> applicants = applicantRepository.findAll(pageable);
        List<GetAllApplicantResponse> responses = applicants.stream()
                .map(applicant -> mapperService.forResponse()
                        .map(applicant, GetAllApplicantResponse.class)).toList();
        return new SuccessDataResult<List<GetAllApplicantResponse>>(responses);
    }


}
