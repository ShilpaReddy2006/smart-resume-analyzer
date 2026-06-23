package com.shilpareddy.smart_resume_analyzer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // store like: "java,spring boot,microservices"
    private String requiredSkills;
}

