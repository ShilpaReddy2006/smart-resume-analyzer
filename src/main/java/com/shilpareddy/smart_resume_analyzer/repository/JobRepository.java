package com.shilpareddy.smart_resume_analyzer.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shilpareddy.smart_resume_analyzer.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}




