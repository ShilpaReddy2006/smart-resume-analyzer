
package com.shilpareddy.smart_resume_analyzer.controller;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.shilpareddy.smart_resume_analyzer.dto.ResumeResponse;
import com.shilpareddy.smart_resume_analyzer.service.ResumeService;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/best")
    public ResumeResponse.JobMatch getBestJob(
            @RequestParam("file") MultipartFile file,
            @RequestHeader("Authorization") String token) {

        ResumeResponse response =
                resumeService.processResume(file, token);

        return response.getJobMatches()
                .stream()
                .max(Comparator.comparingInt(ResumeResponse.JobMatch::getScore))
                .orElse(null);
    }
}

