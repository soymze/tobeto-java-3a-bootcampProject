package com.bootcamp.com.bootcamp.business.concretes;

import com.bootcamp.com.bootcamp.business.abstracts.EmployeeService;
import com.bootcamp.com.bootcamp.business.constants.ApplicantMessages;
import com.bootcamp.com.bootcamp.business.constants.EmployeeMessages;
import com.bootcamp.com.bootcamp.business.requests.create.employee.CreateEmployeeRequest;
import com.bootcamp.com.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.bootcamp.com.bootcamp.business.responses.get.applicant.GetByAbout;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetByPosition;
import com.bootcamp.com.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.bootcamp.com.bootcamp.core.utilities.mapping.ModelMapperService;
import com.bootcamp.com.bootcamp.core.utilities.results.DataResult;
import com.bootcamp.com.bootcamp.core.utilities.results.SuccessDataResult;
import com.bootcamp.com.bootcamp.dataAccess.EmployeeRepository;
import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest request) {
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
}
