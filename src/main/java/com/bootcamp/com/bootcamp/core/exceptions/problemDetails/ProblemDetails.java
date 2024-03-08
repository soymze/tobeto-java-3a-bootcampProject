package com.bootcamp.com.bootcamp.core.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemDetails {
    private String title;
    private String detail;
    private String status;
    private String type;
}
