package org.example.stack.BOJ10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > 0) {
                stack.push(value);
            } else if (value == 0) {
                stack.pop();
            }
        }

        int sum = stack.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
