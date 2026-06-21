package com.shilpareddy.smart_resume_analyzer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shilpareddy.smart_resume_analyzer.dto.ResumeResponse;
import com.shilpareddy.smart_resume_analyzer.model.Resume;
import com.shilpareddy.smart_resume_analyzer.repository.ResumeRepository;
import com.shilpareddy.smart_resume_analyzer.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    private ResumeRepository resumeRepository;
    @GetMapping("/all")
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    @PostMapping("/upload")
    public ResumeResponse upload(
            @RequestParam("file") MultipartFile file,
            @RequestHeader("Authorization") String token) {

        return resumeService.processResume(file, token);
    }
}





