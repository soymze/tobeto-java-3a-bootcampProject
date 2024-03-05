package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.InstructorService;
import com.bootcamp.com.bootcamp.business.requests.create.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.dataAccess.InstructorRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Employee;
import com.bootcamp.com.bootcamp.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;

    @Override
    public CreateInstructorResponse create(CreateInstructorRequest request) {

        Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = mapperService.forResponse()
                .map(instructor, CreateInstructorResponse.class);
        return response;
    }

    @Override
    public List<GetAllInstructorResponse> getAll() {

        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> instructorResponses =
                instructors.stream().map(instructor -> mapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
                        .collect(Collectors.toList());
        return instructorResponses;
    }

    @Override
    public GetInstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id);
        GetInstructorResponse response =
                mapperService.forResponse().map(instructor, GetInstructorResponse.class);
        return response;
    }
    @Override
    public Instructor updateInstructor(Instructor inputInstructor, int id) {
        Instructor insDB = instructorRepository.findById(id);
        insDB.setFirstName(inputInstructor.getFirstName());
        return instructorRepository.save(insDB);
    }

    @Override
    public void deleteInstructorById(int id) {
        instructorRepository.deleteById(id);
    }
    @Override
    public GetByCompanyName getByCompanyName(String companyName) {
        Instructor instructor = instructorRepository.findByCompanyName(companyName);
        GetByCompanyName response =
                mapperService.forResponse().map(instructor, GetByCompanyName.class);
        return response;
    }
}
