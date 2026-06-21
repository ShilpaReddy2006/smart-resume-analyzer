package com.shilpareddy.smart_resume_analyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @Lob
    private String extractedText;

    private String skills;

    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

