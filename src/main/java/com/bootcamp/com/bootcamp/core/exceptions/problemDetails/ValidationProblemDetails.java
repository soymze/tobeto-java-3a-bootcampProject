package com.bootcamp.com.bootcamp.core.exceptions.problemDetails;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;
@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails (){
        setTitle("Validation Rule Violation");
        setType("http://tobeto.com/exceptions/validation");
        setDetail("Validation Problem");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }

    private Map<String, String> errors;
}
