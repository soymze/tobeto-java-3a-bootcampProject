package com.bootcamp.com.bootcamp.business.abstracts;

import com.bootcamp.com.bootcamp.business.requests.create.instructor.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.entities.Instructor;

import java.util.List;

public interface InstructorService {


    DataResult<CreateInstructorResponse> create(CreateInstructorRequest request);
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<GetInstructorResponse> getById(int id);
    DataResult<Instructor> updateInstructor(Instructor instructor, int id);
    DataResult<?> deleteInstructorById(int id);
    DataResult<GetByCompanyName> getByCompanyName(String companyName);
}
