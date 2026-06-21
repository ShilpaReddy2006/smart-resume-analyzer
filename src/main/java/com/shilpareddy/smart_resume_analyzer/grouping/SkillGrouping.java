package com.shilpareddy.smart_resume_analyzer.grouping;

import java.util.*;

public class SkillGrouping {

    public static final Map<String, String> GROUP_MAP = new HashMap<>();

    static {

        // Java ecosystem
        GROUP_MAP.put("java", "backend");
        GROUP_MAP.put("spring", "backend");
        GROUP_MAP.put("spring boot", "backend");
        GROUP_MAP.put("microservices", "backend");

        // Frontend
        GROUP_MAP.put("html", "frontend");
        GROUP_MAP.put("css", "frontend");
        GROUP_MAP.put("javascript", "frontend");
        GROUP_MAP.put("react", "frontend");

        // Data
        GROUP_MAP.put("sql", "database");
        GROUP_MAP.put("mysql", "database");

        // Cloud
        GROUP_MAP.put("aws", "cloud");
        GROUP_MAP.put("docker", "cloud");
        GROUP_MAP.put("kubernetes", "cloud");
    }

    public static String getGroup(String skill) {
        return GROUP_MAP.getOrDefault(skill.toLowerCase(), "other");
    }
}