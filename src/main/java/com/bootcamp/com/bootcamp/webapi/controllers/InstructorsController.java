package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.InstructorService;
import com.bootcamp.com.bootcamp.business.requests.create.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController {

    @Autowired
    private InstructorService instructorService;
    @PostMapping()
    public CreateInstructorResponse create(@RequestBody CreateInstructorRequest request){
        CreateInstructorResponse result = instructorService.create(request);
        return result;
    }
    @GetMapping("getallInstructors")
    public List<GetAllInstructorResponse> getAll(){
        return instructorService.getAll();
    }

    @GetMapping("getbyid/{id}")
    public GetInstructorResponse getById(@PathVariable int id){
        return instructorService.getById(id);
    }
}
