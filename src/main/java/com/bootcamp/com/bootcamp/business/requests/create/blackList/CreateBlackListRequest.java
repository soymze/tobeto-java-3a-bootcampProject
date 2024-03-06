package com.bootcamp.com.bootcamp.business.requests.create.blackList;

import com.bootcamp.com.bootcamp.entities.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlackListRequest {
    private int id;
    private String reason;
    private LocalDateTime date;
    private Applicant applicant;
}
