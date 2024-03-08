package com.bootcamp.com.bootcamp.dataAccess;

import com.bootcamp.com.bootcamp.entities.Application;
import com.bootcamp.com.bootcamp.entities.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
    Bootcamp findById(int id);
}
