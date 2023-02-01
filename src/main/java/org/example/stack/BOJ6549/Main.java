package org.example.stack.BOJ6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            map = new int[n + 2];
            for (int i = 1; i < n + 1; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int ans = 0;
            for (int i = 1; i < n + 2; i++) {
                while (!stack.isEmpty() && map[stack.peek()] > map[i]) {
                    int top = stack.peek();
                    stack.pop();
                    ans = Math.max(ans, map[top] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }
    }
}
