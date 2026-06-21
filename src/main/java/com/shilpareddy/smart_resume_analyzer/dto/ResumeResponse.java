package com.shilpareddy.smart_resume_analyzer.dto;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeResponse {

    private List<String> resumeSkills;

    private List<JobMatch> jobMatches;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JobMatch {
        private String jobTitle;
        private int score;
        private List<String> matchedSkills;
        private List<String> missingSkills;
    }
}

