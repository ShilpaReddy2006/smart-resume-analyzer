package com.shilpareddy.smart_resume_analyzer.util;
import java.util.*;

import com.shilpareddy.smart_resume_analyzer.normalizer.SmartSkillNormalizer;

public class SkillExtractor {

    private static final List<String> SKILLS = Arrays.asList(
            "java",
            "spring boot",
            "sql",
            "python",
            "html",
            "css",
            "javascript",
            "react",
            "aws",
            "docker",
            "kubernetes",
            "microservices"
    );

    public static List<String> extractSkills(String text) {

        List<String> foundSkills = new ArrayList<>();

        String lowerText = text.toLowerCase()
                .replaceAll("[^a-zA-Z ]", " ");

        for (String skill : SKILLS) {

            if (lowerText.contains(skill)) {
                foundSkills.add(skill);
            } else {
                // check normalized versions
                String normalized = SmartSkillNormalizer.normalize(skill);
                if (!skill.equals(normalized) && lowerText.contains(normalized)) {
                    foundSkills.add(skill);
                }
            }
        }

        return foundSkills;
    }
}

