package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Instructor;
import com.bootcamp.com.bootcamp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    Instructor findById(int id);
    Instructor findByCompanyName(String companyName);
    User getByEmail(String email);
}
