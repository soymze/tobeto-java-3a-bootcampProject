package com.bootcamp.com.bootcamp.business.abstracts;


import com.bootcamp.com.bootcamp.business.requests.create.application.CreateApplicationRequest;
import com.bootcamp.com.bootcamp.business.responses.create.application.CreateApplicationResponse;
import com.bootcamp.com.bootcamp.business.responses.get.application.GetAllApplicationResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.Application;

import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> create(CreateApplicationRequest request);
    DataResult<List<GetAllApplicationResponse>> getAll();
    DataResult<Application> updateApplication(Application application, int id);
    DataResult<?> deleteApplicationById(int id);

}
