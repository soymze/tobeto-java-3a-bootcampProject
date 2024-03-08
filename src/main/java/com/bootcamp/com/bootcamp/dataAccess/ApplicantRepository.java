package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Applicant;
import com.bootcamp.com.bootcamp.entities.Instructor;
import com.bootcamp.com.bootcamp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

    Applicant findById(int id);
    Applicant findByAbout(String about);
    User getByEmail(String email);

}
