package com.bootcamp.com.bootcamp.business.requests.create.applicationState;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationStateRequest {

    private int id;
    private String name;
}
