package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.InstructorService;
import com.bootcamp.com.bootcamp.business.requests.create.instructor.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController extends BaseController{

    @Autowired
    private InstructorService instructorService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateInstructorRequest request){
        return handleDataResult(instructorService.create(request));
    }
    @GetMapping("getallInstructors")
    public ResponseEntity<?> getAll(){
        return handleDataResult(instructorService.getAll());
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(instructorService.getById(id));
    }
    @PutMapping("/updateInstructor/{id}")
    public ResponseEntity<?> updateApplicant(@RequestBody Instructor inputInstructor, @PathVariable("id") int id) {
        return handleDataResult(instructorService.updateInstructor(inputInstructor, id));
    }
    @DeleteMapping("/deleteInstructorById/{id}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable("id") int id){
        return handleDataResult(instructorService.deleteInstructorById(id));
    }
    @GetMapping("getbycompanyname/{companyName}")
    public ResponseEntity<?> getByCompanyName(@PathVariable String companyName){
        return handleDataResult(instructorService.getByCompanyName(companyName));
    }
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(instructorService.getAllPage(pageDto));
    }
}
