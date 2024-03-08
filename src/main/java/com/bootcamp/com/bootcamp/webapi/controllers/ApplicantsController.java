package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.ApplicantService;
import com.bootcamp.com.bootcamp.business.requests.create.applicant.CreateApplicantRequest;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.Applicant;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController extends BaseController{

    @Autowired
    private ApplicantService applicantService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateApplicantRequest request){
        return handleDataResult(applicantService.create(request));
    }
    @GetMapping("getallApplicants")
    public ResponseEntity<?> getAll(){
        return handleDataResult(applicantService.getAll());
    }
    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicantService.getById(id));
    }
    @PutMapping("/updateApplicant/{id}")
    public ResponseEntity<?> updateApplicant(@RequestBody Applicant inputApplicant, @PathVariable("id") int id) {
        return handleDataResult(applicantService.updateApplicant(inputApplicant, id));
    }
    @DeleteMapping("/deleteApplicantById/{id}")
    public ResponseEntity<?>  deleteApplicantById(@PathVariable("id") int id){
        return handleDataResult(applicantService.deleteApplicantById(id));
    }
    @GetMapping("getbyabout/{about}")
    public ResponseEntity<?> getByAbout(@PathVariable String about){
        return handleDataResult(applicantService.getByAbout(about));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(applicantService.getAllPage(pageDto));
    }
}
