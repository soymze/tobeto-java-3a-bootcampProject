package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Instructor;

import java.util.List;

public interface InstructorService {


    CreateInstructorResponse create(CreateInstructorRequest request);
    List<GetAllInstructorResponse> getAll();
    GetInstructorResponse getById(int id);
    Instructor updateInstructor(Instructor instructor, int id);
    void deleteInstructorById(int id);
    GetByCompanyName getByCompanyName(String companyName);
}
