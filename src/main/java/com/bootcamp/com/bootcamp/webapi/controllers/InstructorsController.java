package com.bootcamp.com.bootcamp.webapi.controllers;


import com.bootcamp.com.bootcamp.business.abstracts.InstructorService;
import com.bootcamp.com.bootcamp.business.requests.create.instructor.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.entities.Instructor;
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
    @PutMapping("/updateInstructor/{id}")
    public Instructor updateApplicant(@RequestBody Instructor inputInstructor, @PathVariable("id") int id) {
        return instructorService.updateInstructor(inputInstructor, id);
    }
    @DeleteMapping("/deleteInstructorById/{id}")
    public String deleteInstructorById(@PathVariable("id") int id){
        instructorService.deleteInstructorById(id);
        return "Deleted Successfully";
    }
    @GetMapping("getbycompanyname/{companyName}")
    public GetByCompanyName getByCompanyName(@PathVariable String companyName){
        return instructorService.getByCompanyName(companyName);
    }
}
