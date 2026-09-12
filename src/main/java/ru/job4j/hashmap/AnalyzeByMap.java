package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int subjectCount = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                subjectCount++;
                sum += subject.score();
            }

        }
        return sum / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            double sum = 0;
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum / subjects.size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> tmpMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                String subjectName = subject.name();
                tmpMap.put(subjectName, tmpMap.getOrDefault(subjectName, 0) + subject.score());
            }
        }
        for (String key : tmpMap.keySet()) {
            result.add(new Label(key, (double) tmpMap.get(key) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            double sum = 0;
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> tmpMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                String subjectName = subject.name();
                tmpMap.put(subjectName, tmpMap.getOrDefault(subjectName, 0) + subject.score());
            }
        }
        for (String key : tmpMap.keySet()) {
            result.add(new Label(key, tmpMap.get(key)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
