package com.bootcamp.com.bootcamp.business.concretes;


import com.bootcamp.com.bootcamp.business.abstracts.BootcampStateService;
import com.bootcamp.com.bootcamp.business.constants.BootcampStateMessages;
import com.bootcamp.com.bootcamp.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.bootcamp.com.bootcamp.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.bootcamp.com.bootcamp.business.responses.get.blackList.GetAllBlackListResponse;
import com.bootcamp.com.bootcamp.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.ApplicationRepository;
import com.bootcamp.com.bootcamp.dataAccess.BootcampStateRepository;
import com.bootcamp.com.bootcamp.entities.BlackList;
import com.bootcamp.com.bootcamp.entities.BootcampState;
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
public class BootcampStateManager implements BootcampStateService {
    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampStateResponse> create(CreateBootcampStateRequest request) {
        BootcampState bootcampState = mapperService.forRequest().map(request, BootcampState.class);
        bootcampStateRepository.save(bootcampState);

        CreateBootcampStateResponse response = mapperService.forResponse()
                .map(bootcampState, CreateBootcampStateResponse.class);
        return new SuccessDataResult<CreateBootcampStateResponse>(response, BootcampStateMessages.BootcampStateAdded);
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAll() {
        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();
        List<GetAllBootcampStateResponse> bootcampStateResponses =
                bootcampStates.stream().map(bootcampState -> mapperService.forResponse().map(bootcampState, GetAllBootcampStateResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampStateResponse>>(bootcampStateResponses,BootcampStateMessages.BootcampStateListed);
    }

    @Override
    public DataResult<BootcampState> updateBootcampState(BootcampState bootcampState, int id) {
        BootcampState bootSDB = bootcampStateRepository.findById(id);
        bootSDB.setName(bootcampState.getName());
        bootcampStateRepository.save(bootSDB);
        return new SuccessDataResult<BootcampState>(bootSDB,BootcampStateMessages.BootcampStateUpdated);
    }

    @Override
    public DataResult<?> deleteBootcampStateById(int id) {
        bootcampStateRepository.deleteById(id);
        return new SuccessDataResult<>(null,BootcampStateMessages.BootcampStateDeleted);
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<BootcampState> bootcampStates = bootcampStateRepository.findAll(pageable);
        List<GetAllBootcampStateResponse> responses = bootcampStates.stream()
                .map(bootcampState -> mapperService.forResponse()
                        .map(bootcampState, GetAllBootcampStateResponse.class)).toList();
        return new SuccessDataResult<List<GetAllBootcampStateResponse>>(responses);
    }
}
