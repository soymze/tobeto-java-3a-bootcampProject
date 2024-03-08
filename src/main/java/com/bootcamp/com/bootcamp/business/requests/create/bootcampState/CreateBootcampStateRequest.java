package com.bootcamp.com.bootcamp.business.requests.create.bootcampState;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampStateRequest {
    private int id;
    @NotEmpty(message = "Bootcamp Status can not be empty.")
    @Size(min = 3,message = "Bootcamp Status can be minimum 3 characters.")
    private String name;
}
