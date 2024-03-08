package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Application;
import com.bootcamp.com.bootcamp.entities.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStateRepository extends JpaRepository<ApplicationState, Integer> {
    ApplicationState findById(int id);
}
