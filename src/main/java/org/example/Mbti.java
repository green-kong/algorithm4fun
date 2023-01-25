package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class Mbti {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> hashMap = new LinkedHashMap<>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};

        for (int i = 0; i < choices.length; i++) {
            int score = choices[i] - 4;
            int targetIndex = score < 0 ? 0 : 1;
            String target = survey[i].split("")[targetIndex];
            hashMap.put(target, hashMap.get(target) + Math.abs(score));
        }

        String[] key = hashMap.keySet().toArray(new String[0]);
        for (int i = 0; i < key.length; i++) {
            if (i % 2 != 0) {
                continue;
            }
            String character1 = key[i];
            String character2 = key[i + 1];
            String correct = hashMap.get(character1) >= hashMap.get(character2)
                    ? character1 : character2;
            answer.append(correct);
        }
        return answer.toString();
    }
}
