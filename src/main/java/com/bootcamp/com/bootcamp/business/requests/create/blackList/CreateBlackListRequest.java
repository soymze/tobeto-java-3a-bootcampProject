package com.bootcamp.com.bootcamp.business.requests.create.blackList;

import com.bootcamp.com.bootcamp.entities.Applicant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlackListRequest {
    private int id;
    @NotEmpty(message = "Reason can not be empty.")
    @Size(min = 3,message = "Reason can be minimum 10 characters.")
    private String reason;
    private LocalDateTime date;
    private Applicant applicant;
}
