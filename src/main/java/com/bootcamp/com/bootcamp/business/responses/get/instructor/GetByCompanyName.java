package com.bootcamp.com.bootcamp.business.responses.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByCompanyName {
    private String firstName;
    private String companyName;
}
