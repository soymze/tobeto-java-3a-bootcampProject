package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.ApplicationState;

import java.util.List;

public interface ApplicationStateService {
    DataResult<CreateApplicationStateResponse> create(CreateApplicationStateRequest request);
    DataResult<List<GetAllApplicationStateResponse>> getAll();
    DataResult<ApplicationState> updateApplicationState(ApplicationState applicationState, int id);
    DataResult<?> deleteApplicationStateById(int id);
    DataResult<List<GetAllApplicationStateResponse>> getAllPage(PageDto pageDto);
}
