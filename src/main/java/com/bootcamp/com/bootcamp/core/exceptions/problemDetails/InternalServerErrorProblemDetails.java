package com.bootcamp.com.bootcamp.core.exceptions.problemDetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails{
    public InternalServerErrorProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://tobeto.com/exceptions/internal");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
