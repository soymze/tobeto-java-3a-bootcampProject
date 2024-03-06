package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.BlacklistService;
import com.bootcamp.com.bootcamp.business.constants.BlackListMessages;
import com.bootcamp.com.bootcamp.business.requests.create.blackList.CreateBlackListRequest;
import com.bootcamp.com.bootcamp.business.responses.create.blackList.CreateBlackListResponse;
import com.bootcamp.com.bootcamp.business.responses.get.blackList.GetAllBlackListResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.BlackListRepository;
import com.bootcamp.com.bootcamp.entities.BlackList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlackListManager implements BlacklistService {
    private BlackListRepository blacklistRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBlackListResponse> create(CreateBlackListRequest request) {
        BlackList blacklist = mapperService.forRequest().map(request, BlackList.class);
        blacklistRepository.save(blacklist);

        CreateBlackListResponse response = mapperService.forResponse()
                .map(blacklist, CreateBlackListResponse.class);
        return new SuccessDataResult<CreateBlackListResponse>(response, BlackListMessages.BlacklistAdded);
    }

    @Override
    public DataResult<List<GetAllBlackListResponse>> getAll() {
        List<BlackList> blackLists = blacklistRepository.findAll();
        List<GetAllBlackListResponse> blacklistResponses =
                blackLists.stream().map(blackList -> mapperService.forResponse().map(blackList, GetAllBlackListResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBlackListResponse>>(blacklistResponses,BlackListMessages.BlacklistListed);
    }

    @Override
    public DataResult<BlackList> updateBlacklist(BlackList blacklist, int id) {
        BlackList blackDB = blacklistRepository.findById(id);
        blackDB.setReason(blacklist.getReason());
        blacklistRepository.save(blackDB);
        return new SuccessDataResult<BlackList>(blackDB,BlackListMessages.BlacklistUpdated);
    }@Override
    public DataResult<?> deleteBlacklistById(int id) {
        blacklistRepository.deleteById(id);
        return new SuccessDataResult<>(null,BlackListMessages.BlacklistDeleted);
    }
}
