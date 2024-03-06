package com.bootcamp.com.bootcamp.business.requests.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampRequest {
    private int id;
    private String name;
}
