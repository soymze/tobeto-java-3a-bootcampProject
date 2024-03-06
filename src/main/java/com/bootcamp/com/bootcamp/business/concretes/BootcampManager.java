package com.bootcamp.com.bootcamp.business.concretes;


import com.bootcamp.com.bootcamp.business.abstracts.BootcampService;
import com.bootcamp.com.bootcamp.business.constants.BootcampMessages;
import com.bootcamp.com.bootcamp.business.requests.create.bootcamp.CreateBootcampRequest;
import com.bootcamp.com.bootcamp.business.responses.create.bootcamp.CreateBootcampResponse;
import com.bootcamp.com.bootcamp.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.BootcampRepository;
import com.bootcamp.com.bootcamp.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampResponse> create(CreateBootcampRequest request) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);
        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = mapperService.forResponse()
                .map(bootcamp, CreateBootcampResponse.class);
        return new SuccessDataResult<CreateBootcampResponse>(response, BootcampMessages.BootcampAdded);
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        List<GetAllBootcampResponse> bootcampResponses =
                bootcamps.stream().map(bootcamp -> mapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses,BootcampMessages.BootcampListed);
    }

    @Override
    public DataResult<Bootcamp> updateBootcamp(Bootcamp bootcamp, int id) {
        Bootcamp bootDB = bootcampRepository.findById(id);
        bootDB.setName(bootcamp.getName());
        bootcampRepository.save(bootDB);
        return new SuccessDataResult<Bootcamp>(bootDB,BootcampMessages.BootcampUpdated);
    }

    @Override
    public DataResult<?> deleteBootcampById(int id) {
        bootcampRepository.deleteById(id);
        return new SuccessDataResult<>(null,BootcampMessages.BootcampDeleted);
    }
}
