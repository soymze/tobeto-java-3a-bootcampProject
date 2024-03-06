package com.bootcamp.com.bootcamp.business.abstracts;


import com.bootcamp.com.bootcamp.business.requests.create.bootcamp.CreateBootcampRequest;
import com.bootcamp.com.bootcamp.business.responses.create.bootcamp.CreateBootcampResponse;
import com.bootcamp.com.bootcamp.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.Bootcamp;

import java.util.List;

public interface BootcampService {
    DataResult<CreateBootcampResponse> create(CreateBootcampRequest request);
    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<Bootcamp> updateBootcamp(Bootcamp bootcamp, int id);
    DataResult<?> deleteBootcampById(int id);
}
