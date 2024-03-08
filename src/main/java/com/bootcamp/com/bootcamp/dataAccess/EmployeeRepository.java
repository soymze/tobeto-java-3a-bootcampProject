package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Employee;
import com.bootcamp.com.bootcamp.entities.Instructor;
import com.bootcamp.com.bootcamp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);
    Employee findByPosition(String position);
    User getByEmail(String email);
}
