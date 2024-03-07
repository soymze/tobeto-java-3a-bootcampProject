package com.bootcamp.com.bootcamp.business.concretes;


import com.bootcamp.com.bootcamp.business.abstracts.ApplicationStateService;
import com.bootcamp.com.bootcamp.business.constants.ApplicationStateMessages;
import com.bootcamp.com.bootcamp.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.ApplicationStateRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.ApplicationState;
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
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateApplicationStateResponse> create(CreateApplicationStateRequest request) {
        ApplicationState applicationState = mapperService.forRequest().map(request, ApplicationState.class);
        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response = mapperService.forResponse()
                .map(applicationState, CreateApplicationStateResponse.class);
        return new SuccessDataResult<CreateApplicationStateResponse>(response, ApplicationStateMessages.ApplicationStateAdded);
    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();
        List<GetAllApplicationStateResponse> applicationStateResponses =
                applicationStates.stream().map(applicationState -> mapperService.forResponse().map(applicationState, GetAllApplicationStateResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationStateResponse>>(applicationStateResponses,ApplicationStateMessages.ApplicationStateListed);
    }

    @Override
    public DataResult<ApplicationState> updateApplicationState(ApplicationState applicationState, int id) {
        ApplicationState apsDB = applicationStateRepository.findById(id);
        apsDB.setName(applicationState.getName());
        applicationStateRepository.save(apsDB);
        return new SuccessDataResult<ApplicationState>(apsDB,ApplicationStateMessages.ApplicationStateUpdated);
    }

    @Override
    public DataResult<?> deleteApplicationStateById(int id) {
        applicationStateRepository.deleteById(id);
        return new SuccessDataResult<>(null,ApplicationStateMessages.ApplicationStateDeleted);
    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<ApplicationState> applicationStates = applicationStateRepository.findAll(pageable);
        List<GetAllApplicationStateResponse> responses = applicationStates.stream()
                .map(applicationState -> mapperService.forResponse()
                        .map(applicationState, GetAllApplicationStateResponse.class)).toList();
        return new SuccessDataResult<List<GetAllApplicationStateResponse>>(responses);
    }
}
