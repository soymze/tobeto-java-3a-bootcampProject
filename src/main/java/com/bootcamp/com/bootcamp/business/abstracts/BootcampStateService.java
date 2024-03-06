package com.bootcamp.com.bootcamp.business.abstracts;


import com.bootcamp.com.bootcamp.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.bootcamp.com.bootcamp.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.bootcamp.com.bootcamp.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.BootcampState;

import java.util.List;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> create(CreateBootcampStateRequest request);
    DataResult<List<GetAllBootcampStateResponse>> getAll();
    DataResult<BootcampState> updateBootcampState(BootcampState bootcampState, int id);
    DataResult<?> deleteBootcampStateById(int id);
}
