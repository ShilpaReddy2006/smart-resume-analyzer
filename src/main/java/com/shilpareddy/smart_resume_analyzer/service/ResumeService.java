package com.shilpareddy.smart_resume_analyzer.service;

import java.util.*;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shilpareddy.smart_resume_analyzer.dto.ResumeResponse;
import com.shilpareddy.smart_resume_analyzer.model.Job;
import com.shilpareddy.smart_resume_analyzer.model.Resume;
import com.shilpareddy.smart_resume_analyzer.model.User;
import com.shilpareddy.smart_resume_analyzer.repository.JobRepository;
import com.shilpareddy.smart_resume_analyzer.repository.ResumeRepository;
import com.shilpareddy.smart_resume_analyzer.repository.UserRepository;
import com.shilpareddy.smart_resume_analyzer.security.JwtUtil;
import com.shilpareddy.smart_resume_analyzer.util.JobMatcher;
import com.shilpareddy.smart_resume_analyzer.util.SkillExtractor;

@Service
public class ResumeService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserRepository userRepository;

        public ResumeResponse processResume(MultipartFile file, String token) {

            try {

                // -------------------------------
                // 1. VALIDATE TOKEN
                // -------------------------------
                if (token == null || !token.startsWith("Bearer ")) {
                    throw new RuntimeException("Invalid Authorization header");
                }

                String jwt = token.substring(7).trim();

                if (!jwt.contains(".")) {
                    throw new RuntimeException("Invalid JWT format");
                }

                // -------------------------------
                // 2. EXTRACT USER FROM JWT
                // -------------------------------
                String email = JwtUtil.extractEmail(jwt);
                User user = userRepository.findByEmail(email);

                if (user == null) {
                    throw new RuntimeException("User not found");
                }

                // -------------------------------
                // 3. CHECK FILE
                // -------------------------------
                if (file == null || file.isEmpty()) {
                    throw new RuntimeException("Uploaded file is empty");
                }

                Tika tika = new Tika();

                String text = tika.parseToString(file.getInputStream());

                if (text == null || text.isBlank()) {
                    throw new RuntimeException("Unable to extract text from resume");
                }

                // -------------------------------
                // 4. EXTRACT SKILLS
                // -------------------------------
                List<String> resumeSkills = SkillExtractor.extractSkills(text);

                // -------------------------------
                // 5. SAVE RESUME IN DB
                // -------------------------------
                Resume resume = new Resume();
                resume.setFileName(file.getOriginalFilename());
                resume.setExtractedText(text);
                resume.setSkills(String.join(",", resumeSkills));
                resume.setScore(0);
                resume.setUser(user);

                resumeRepository.save(resume);

                // -------------------------------
                // 6. JOB MATCHING
                // -------------------------------
                List<Job> jobs = jobRepository.findAll();
                List<ResumeResponse.JobMatch> matches = new ArrayList<>();

                for (Job job : jobs) {

                    Map<String, Object> result =
                            JobMatcher.match(resumeSkills, job.getRequiredSkills());

                    matches.add(
                            new ResumeResponse.JobMatch(
                                    job.getTitle(),
                                    (int) result.get("score"),
                                    (List<String>) result.get("matchedSkills"),
                                    (List<String>) result.get("missingSkills")
                            )
                    );
                }

                // -------------------------------
                // 7. RESPONSE
                // -------------------------------
                return new ResumeResponse(resumeSkills, matches);

            } catch (Exception e) {
                throw new RuntimeException("Resume processing failed: " + e.getMessage());
            }
        }
    }