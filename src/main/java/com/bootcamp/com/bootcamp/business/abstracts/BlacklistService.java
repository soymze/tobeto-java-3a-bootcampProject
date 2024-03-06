package com.bootcamp.com.bootcamp.business.abstracts;


import com.bootcamp.com.bootcamp.business.requests.create.blackList.CreateBlackListRequest;
import com.bootcamp.com.bootcamp.business.responses.create.blackList.CreateBlackListResponse;
import com.bootcamp.com.bootcamp.business.responses.get.blackList.GetAllBlackListResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.BlackList;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlackListResponse> create(CreateBlackListRequest request);
    DataResult<List<GetAllBlackListResponse>> getAll();
    DataResult<BlackList> updateBlacklist(BlackList blacklist, int id);
    DataResult<?> deleteBlacklistById(int id);
}
