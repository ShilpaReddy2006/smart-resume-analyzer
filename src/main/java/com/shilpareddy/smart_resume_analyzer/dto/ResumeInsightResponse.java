package com.shilpareddy.smart_resume_analyzer.dto;

import java.util.List;

public class ResumeInsightResponse {

    private String profileLevel;
    private List<String> strongSkills;
    private List<String> weakSkills;
    private String recommendation;

    public ResumeInsightResponse(String profileLevel,
                                 List<String> strongSkills,
                                 List<String> weakSkills,
                                 String recommendation) {
        this.profileLevel = profileLevel;
        this.strongSkills = strongSkills;
        this.weakSkills = weakSkills;
        this.recommendation = recommendation;
    }

    public String getProfileLevel() {
        return profileLevel;
    }

    public List<String> getStrongSkills() {
        return strongSkills;
    }

    public List<String> getWeakSkills() {
        return weakSkills;
    }

    public String getRecommendation() {
        return recommendation;
    }
}