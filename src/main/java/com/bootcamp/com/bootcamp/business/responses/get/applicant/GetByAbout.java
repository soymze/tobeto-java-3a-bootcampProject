package com.bootcamp.com.bootcamp.business.responses.get.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByAbout {

    private String firstName;
    private String about;
}
