package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.InstructorService;
import com.bootcamp.com.bootcamp.business.constants.ApplicantMessages;
import com.bootcamp.com.bootcamp.business.constants.InstructorMessages;
import com.bootcamp.com.bootcamp.business.requests.create.instructor.CreateInstructorRequest;
import com.bootcamp.com.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetAllInstructorResponse;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetByCompanyName;
import com.bootcamp.com.bootcamp.business.responses.get.instructor.GetInstructorResponse;
import com.bootcamp.com.bootcamp.business.rules.InstructorBusinessRules;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.InstructorRepository;
import com.bootcamp.com.bootcamp.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    private InstructorBusinessRules instructorBusinessRules;

    @Override
    public DataResult<CreateInstructorResponse> create(CreateInstructorRequest request) {
        instructorBusinessRules.checkIfMailExists(request.getEmail());
        Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = mapperService.forResponse()
                .map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(response, InstructorMessages.InstructorAdded);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {

        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> instructorResponses =
                instructors.stream().map(instructor -> mapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(instructorResponses,InstructorMessages.InstructorListed);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor = instructorRepository.findById(id);
        GetInstructorResponse response =
                mapperService.forResponse().map(instructor, GetInstructorResponse.class);
        return new SuccessDataResult<GetInstructorResponse>(response,InstructorMessages.InstructorListed);
    }
    @Override
    public DataResult<Instructor> updateInstructor(Instructor inputInstructor, int id) {
        Instructor insDB = instructorRepository.findById(id);
        insDB.setFirstName(inputInstructor.getFirstName());
        instructorRepository.save(insDB);
        return new SuccessDataResult<Instructor>(insDB,InstructorMessages.InstructorUpdated);
    }

    @Override
    public DataResult<?> deleteInstructorById(int id) {
        instructorRepository.deleteById(id);
        return new SuccessDataResult<>(null,InstructorMessages.InstructorDeleted);
    }
    @Override
    public DataResult<GetByCompanyName> getByCompanyName(String companyName) {
        Instructor instructor = instructorRepository.findByCompanyName(companyName);
        GetByCompanyName response =
                mapperService.forResponse().map(instructor, GetByCompanyName.class);
        return new SuccessDataResult<GetByCompanyName>(response,ApplicantMessages.ApplicantListed);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Instructor> instructors = instructorRepository.findAll(pageable);
        List<GetAllInstructorResponse> responses = instructors.stream()
                .map(instructor -> mapperService.forResponse()
                        .map(instructor, GetAllInstructorResponse.class)).toList();
        return new SuccessDataResult<List<GetAllInstructorResponse>>(responses);
    }
}
