package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Application;
import com.bootcamp.com.bootcamp.entities.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampStateRepository extends JpaRepository<BootcampState, Integer> {
    BootcampState findById(int id);
}
