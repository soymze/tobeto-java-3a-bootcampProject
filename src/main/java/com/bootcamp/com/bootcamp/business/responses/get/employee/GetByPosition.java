package com.bootcamp.com.bootcamp.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByPosition {
    private String firstName;
    private String position;
}
