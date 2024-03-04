package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.ApplicantService;
import com.bootcamp.com.bootcamp.business.requests.create.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController {

    @Autowired
    private ApplicantService applicantService;
    @PostMapping()
    public CreateApplicantResponse create(@RequestBody CreateApplicantRequest request){
        CreateApplicantResponse result = applicantService.create(request);
        return result;
    }
    @GetMapping("getallApplicants")
    public List<GetAllApplicantResponse> getAll(){
        return applicantService.getAll();
    }
    @GetMapping("getbyid/{id}")
    public GetApplicantResponse getById(@PathVariable int id){
        return applicantService.getById(id);
    }
}
