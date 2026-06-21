package com.shilpareddy.smart_resume_analyzer.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.shilpareddy.smart_resume_analyzer.dto.ResumeInsightResponse;

@Service
public class ResumeInsightService {

    private static final List<String> CORE_BACKEND = Arrays.asList(
            "java", "spring boot", "microservices", "sql"
    );

    private static final List<String> FRONTEND = Arrays.asList(
            "html", "css", "javascript", "react"
    );

    public ResumeInsightResponse analyze(List<String> skills) {

        List<String> strong = new ArrayList<>();
        List<String> weak = new ArrayList<>();

        Set<String> skillSet = new HashSet<>(skills);

        int backendCount = 0;
        int frontendCount = 0;

        for (String s : skills) {

            if (CORE_BACKEND.contains(s)) {
                backendCount++;
            }

            if (FRONTEND.contains(s)) {
                frontendCount++;
            }
        }

        // classify strengths & weaknesses
        for (String core : CORE_BACKEND) {
            if (skillSet.contains(core)) {
                strong.add(core);
            } else {
                weak.add(core);
            }
        }

        for (String front : FRONTEND) {
            if (skillSet.contains(front)) {
                strong.add(front);
            } else {
                weak.add(front);
            }
        }

        // profile level logic
        String level;

        int total = backendCount + frontendCount;

        if (total >= 6) {
            level = "Advanced Full Stack Developer";
        } else if (total >= 3) {
            level = "Intermediate Developer";
        } else {
            level = "Beginner Developer";
        }

        String recommendation;

        if (backendCount > frontendCount) {
            recommendation = "Focus on Spring Boot + Microservices";
        } else {
            recommendation = "Focus on React + Advanced Frontend";
        }

        return new ResumeInsightResponse(level, strong, weak, recommendation);
    }
}