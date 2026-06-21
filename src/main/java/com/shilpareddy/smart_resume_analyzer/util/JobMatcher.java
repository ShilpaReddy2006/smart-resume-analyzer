package com.shilpareddy.smart_resume_analyzer.util;

import java.util.*;

import com.shilpareddy.smart_resume_analyzer.grouping.SkillGrouping;
import com.shilpareddy.smart_resume_analyzer.normalizer.SmartSkillNormalizer;

public class JobMatcher {

    public static Map<String, Object> match(List<String> resumeSkills, String requiredSkills) {

        Set<String> resumeSet = new HashSet<>();
        Set<String> resumeGroups = new HashSet<>();

        for (String s : resumeSkills) {
            String normalized = SmartSkillNormalizer.normalize(s);
            resumeSet.add(normalized);
            resumeGroups.add(SkillGrouping.getGroup(normalized));
        }

        String[] jobSkills = requiredSkills.toLowerCase().split(",");

        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        int totalScore = 0;
        int maxScore = jobSkills.length * 10;

        for (String skill : jobSkills) {

            skill = skill.trim();
            String normalized = SmartSkillNormalizer.normalize(skill);

            if (resumeSet.contains(normalized)) {
                matched.add(skill);
                totalScore += 10;
            }
            else if (resumeGroups.contains(SkillGrouping.getGroup(normalized))) {
                matched.add(skill);
                totalScore += 5; // partial match
            }
            else {
                missing.add(skill);
            }
        }

        int finalScore = (int) (((double) totalScore / maxScore) * 100);

        Map<String, Object> result = new HashMap<>();
        result.put("score", finalScore);
        result.put("matchedSkills", matched);
        result.put("missingSkills", missing);

        return result;
    }
}