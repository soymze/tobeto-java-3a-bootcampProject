package com.bootcamp.com.bootcamp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="blacklists")
public class BlackList {
    @Id
    @Column(name = "blacklistId")
    private int id;
    @Column(name = "reason")
    private String reason;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
}
