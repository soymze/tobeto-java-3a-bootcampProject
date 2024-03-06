package com.bootcamp.com.bootcamp.business.concretes;


import com.bootcamp.com.bootcamp.business.abstracts.ApplicationService;
import com.bootcamp.com.bootcamp.business.constants.ApplicationMessages;
import com.bootcamp.com.bootcamp.business.requests.create.application.CreateApplicationRequest;
import com.bootcamp.com.bootcamp.business.responses.create.application.CreateApplicationResponse;
import com.bootcamp.com.bootcamp.business.responses.get.application.GetAllApplicationResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.ApplicationRepository;
import com.bootcamp.com.bootcamp.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateApplicationResponse> create(CreateApplicationRequest request) {
        Application application = mapperService.forRequest().map(request, Application.class);
        applicationRepository.save(application);

        CreateApplicationResponse response = mapperService.forResponse()
                .map(application, CreateApplicationResponse.class);
        return new SuccessDataResult<CreateApplicationResponse>(response, ApplicationMessages.ApplicationAdded);
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<GetAllApplicationResponse> applicationResponses =
                applications.stream().map(application -> mapperService.forResponse().map(application, GetAllApplicationResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationResponse>>(applicationResponses,ApplicationMessages.ApplicationListed);
    }

    @Override
    public DataResult<Application> updateApplication(Application inputApplication, int id) {
        Application appDB = applicationRepository.findById(id);
        appDB.setApplicant(inputApplication.getApplicant());
        applicationRepository.save(appDB);
        return new SuccessDataResult<Application>(appDB,ApplicationMessages.ApplicationUpdated);
    }

    @Override
    public DataResult<?> deleteApplicationById(int id) {
        applicationRepository.deleteById(id);
        return new SuccessDataResult<>(null,ApplicationMessages.ApplicationDeleted);
    }
}
