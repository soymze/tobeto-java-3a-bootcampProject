package com.bootcamp.com.bootcamp.business.requests.create.bootcamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampRequest {
    private int id;
    @NotEmpty(message = "Bootcamp name can not be empty.")
    @Size(min = 3,message = "Bootcamp name be minimum 2 characters.")
    private String name;
}
