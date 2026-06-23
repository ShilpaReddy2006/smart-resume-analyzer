package com.shilpareddy.smart_resume_analyzer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shilpareddy.smart_resume_analyzer.model.Job;
import com.shilpareddy.smart_resume_analyzer.repository.JobRepository;

import jakarta.annotation.PostConstruct;

@Service
public class JobInitService {

    @Autowired
    private JobRepository jobRepository;

    @PostConstruct
    public void init() {

        if (jobRepository.count() == 0) {

            jobRepository.save(new Job(null,
                    "Java Backend Developer",
                    "java,spring boot,microservices,sql"));

            jobRepository.save(new Job(null,
                    "Full Stack Developer",
                    "java,spring boot,react,html,css,javascript,sql"));

            jobRepository.save(new Job(null,
                    "Cloud Engineer",
                    "aws,docker,kubernetes,linux,terraform"));
        }
    }
}

