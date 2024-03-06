package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.BlacklistService;
import com.bootcamp.com.bootcamp.business.requests.create.blackList.CreateBlackListRequest;
import com.bootcamp.com.bootcamp.entities.BlackList;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blackLists")
@AllArgsConstructor
public class BlackListsController extends BaseController{
    @Autowired
    private BlacklistService blacklistService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateBlackListRequest request){
        return handleDataResult(blacklistService.create(request));
    }
    @GetMapping("getallBlackLists")
    public ResponseEntity<?> getAll(){
        return handleDataResult(blacklistService.getAll());
    }
    @PutMapping("/updateBlackList/{id}")
    public ResponseEntity<?> updateBlacklist(@RequestBody BlackList inputBlackList, @PathVariable("id") int id) {
        return handleDataResult(blacklistService.updateBlacklist(inputBlackList, id));
    }
    @DeleteMapping("/deleteBlackListById/{id}")
    public ResponseEntity<?>  deleteBlackListById(@PathVariable("id") int id){
        return handleDataResult(blacklistService.deleteBlacklistById(id));
    }
}
