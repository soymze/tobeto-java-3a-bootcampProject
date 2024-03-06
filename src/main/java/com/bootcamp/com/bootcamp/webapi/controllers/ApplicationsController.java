package com.bootcamp.com.bootcamp.webapi.controllers;

import com.bootcamp.com.bootcamp.business.abstracts.ApplicationService;
import com.bootcamp.com.bootcamp.business.requests.create.application.CreateApplicationRequest;
import com.bootcamp.com.bootcamp.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationsController extends BaseController{
    @Autowired
    private ApplicationService applicationService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateApplicationRequest request){
        return handleDataResult(applicationService.create(request));
    }
    @GetMapping("getallApplications")
    public ResponseEntity<?> getAll(){
        return handleDataResult(applicationService.getAll());
    }
    @PutMapping("/updateApplication/{id}")
    public ResponseEntity<?> updateApplication(@RequestBody Application inputApplication, @PathVariable("id") int id) {
        return handleDataResult(applicationService.updateApplication(inputApplication, id));
    }
    @DeleteMapping("/deleteApplicationById/{id}")
    public ResponseEntity<?>  deleteApplicationById(@PathVariable("id") int id){
        return handleDataResult(applicationService.deleteApplicationById(id));
    }
}
