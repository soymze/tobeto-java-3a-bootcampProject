package com.bootcamp.com.bootcamp.business.requests.create.applicationState;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationStateRequest {

    private int id;
    @NotEmpty(message = "Status can not be empty.")
    @Size(min = 3,message = "Status can be minimum 3 characters.")
    private String name;
}
