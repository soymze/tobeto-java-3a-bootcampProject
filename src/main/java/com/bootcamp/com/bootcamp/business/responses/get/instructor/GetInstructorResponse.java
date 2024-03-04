package com.bootcamp.com.bootcamp.business.responses.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetInstructorResponse {
    private int id;
    private String firstName;
    private String userName;
}
