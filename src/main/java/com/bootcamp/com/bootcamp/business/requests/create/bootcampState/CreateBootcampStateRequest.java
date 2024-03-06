package com.bootcamp.com.bootcamp.business.requests.create.bootcampState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampStateRequest {
    private int id;
    private String name;
}
