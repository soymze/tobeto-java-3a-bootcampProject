package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.ApplicationStateService;
import com.bootcamp.com.bootcamp.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicationstates")
@AllArgsConstructor
public class ApplicationStatesController extends BaseController{
    @Autowired
    private ApplicationStateService applicationStateService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateApplicationStateRequest request){
        return handleDataResult(applicationStateService.create(request));
    }
    @GetMapping("getallApplicationStates")
    public ResponseEntity<?> getAll(){
        return handleDataResult(applicationStateService.getAll());
    }
    @PutMapping("/updateApplicationState/{id}")
    public ResponseEntity<?> updateApplicationState(@RequestBody ApplicationState applicationState, @PathVariable("id") int id) {
        return handleDataResult(applicationStateService.updateApplicationState(applicationState, id));
    }
    @DeleteMapping("/deleteApplicationStateById/{id}")
    public ResponseEntity<?>  deleteApplicationStateById(@PathVariable("id") int id){
        return handleDataResult(applicationStateService.deleteApplicationStateById(id));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(applicationStateService.getAllPage(pageDto));
    }
}
