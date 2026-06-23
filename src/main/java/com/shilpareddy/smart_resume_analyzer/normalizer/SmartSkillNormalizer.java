package com.shilpareddy.smart_resume_analyzer.normalizer;

import java.util.HashMap;
import java.util.Map;

public class SmartSkillNormalizer {

    private static final Map<String, String> NORMALIZATION_MAP = new HashMap<>();

    static {
        // Java ecosystem
        NORMALIZATION_MAP.put("spring", "spring boot");
        NORMALIZATION_MAP.put("springboot", "spring boot");

        // JS ecosystem
        NORMALIZATION_MAP.put("js", "javascript");

        // Cloud
        NORMALIZATION_MAP.put("aws", "aws");

        // DB
        NORMALIZATION_MAP.put("mysql", "sql");
    }

    public static String normalize(String skill) {
        if (skill == null) return null;

        skill = skill.toLowerCase().trim();

        return NORMALIZATION_MAP.getOrDefault(skill, skill);
    }
}
