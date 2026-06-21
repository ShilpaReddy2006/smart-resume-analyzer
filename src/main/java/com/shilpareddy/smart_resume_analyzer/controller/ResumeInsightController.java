package com.shilpareddy.smart_resume_analyzer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shilpareddy.smart_resume_analyzer.dto.ResumeInsightResponse;
import com.shilpareddy.smart_resume_analyzer.service.ResumeInsightService;

@RestController
@RequestMapping("/insight")
public class ResumeInsightController {

    @Autowired
    private ResumeInsightService insightService;

    @PostMapping
    public ResumeInsightResponse analyze(@RequestBody List<String> skills) {
        return insightService.analyze(skills);
    }
}