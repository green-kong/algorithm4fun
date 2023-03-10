package org.example.stack.BOJ2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    public static final TreeSet<String> REMOVED = new TreeSet<>();
    public static final ArrayList<Brackets> BRACKET_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                s.push(i);
            }

            if (c == ')') {
                BRACKET_LIST.add(new Brackets(s.pop(), i));
            }
        }

        for (int i = 0; i < BRACKET_LIST.size(); i++) {
            removeBracket(i, input);
        }

        REMOVED.forEach(s1 -> sb.append(s1).append("\n"));

        System.out.println(sb);
    }

    private static void removeBracket(int count, String input) {
        if (count >= BRACKET_LIST.size()) {
            return;
        }
        StringBuilder s = new StringBuilder(input);
        Brackets brackets = BRACKET_LIST.get(count);
        s.setCharAt(brackets.leftIdx, 'a');
        s.setCharAt(brackets.rightIdx, 'a');

        String a = s.toString();
        REMOVED.add(a.replace("a", ""));

        count += 1;
        removeBracket(count, input);
        removeBracket(count, a);
    }

    static class Brackets {
        int leftIdx;
        int rightIdx;

        public Brackets(int leftIdx, int rightIdx) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }
    }
}
