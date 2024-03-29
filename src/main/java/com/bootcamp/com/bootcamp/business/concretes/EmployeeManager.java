package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.EmployeeService;
import com.bootcamp.com.bootcamp.business.constants.EmployeeMessages;
import com.bootcamp.com.bootcamp.business.requests.create.employee.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.business.rules.EmployeeBusinessRules;
import com.bootcamp.com.bootcamp.core.paging.PageDto;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.EmployeeRepository;
import com.bootcamp.com.bootcamp.entities.Employee;
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
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;
    private EmployeeBusinessRules employeeBusinessRules;

    @Override
    public DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest request) {
        employeeBusinessRules.checkIfMailExists(request.getEmail());
        Employee employee = mapperService.forRequest().map(request, Employee.class);
        employeeRepository.save(employee);

        CreateEmployeeResponse response = mapperService.forResponse()
                .map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<CreateEmployeeResponse>(response, EmployeeMessages.EmployeeAdded);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {

        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeResponses =
                employees.stream().map(employee -> mapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllEmployeeResponse>>(employeeResponses,EmployeeMessages.EmployeeListed);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        Employee employee = employeeRepository.findById(id);
        GetEmployeeResponse response =
                mapperService.forResponse().map(employee, GetEmployeeResponse.class);
        return new SuccessDataResult<GetEmployeeResponse>(response,EmployeeMessages.EmployeeListed);
    }

    @Override
    public DataResult<Employee> updateEmployee(Employee inputEmployee, int id) {
        Employee empDB = employeeRepository.findById(id);
        empDB.setFirstName(inputEmployee.getFirstName());
        employeeRepository.save(empDB);
        return new SuccessDataResult<Employee>(empDB,EmployeeMessages.EmployeeUpdated);
    }

    @Override
    public DataResult<?> deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return new SuccessDataResult<>(null,EmployeeMessages.EmployeeDeleted);
    }
    @Override
    public DataResult<GetByPosition> getByPosition(String position) {
        Employee employee = employeeRepository.findByPosition(position);
        GetByPosition response =
                mapperService.forResponse().map(employee, GetByPosition.class);
        return new SuccessDataResult<GetByPosition>(response,EmployeeMessages.EmployeeListed);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<GetAllEmployeeResponse> responses = employees.stream()
                .map(employee -> mapperService.forResponse()
                        .map(employee, GetAllEmployeeResponse.class)).toList();
        return new SuccessDataResult<List<GetAllEmployeeResponse>>(responses);
    }
}
