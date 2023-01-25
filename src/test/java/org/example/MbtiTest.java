package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MbtiTest {
    Mbti solution = new Mbti();

    @Test
    void test() {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String solution1 = solution.solution(survey, choices);
        System.out.println(solution1);
    }

    @Test
    void test2() {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7,1,3};
        String solution1 = solution.solution(survey, choices);
        System.out.println(solution1);
    }
}