package org.example.queue.BOJ1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        for (int i = 1; i < n + 1; i++) {
            q.offer(i);
        }
        sb.append("<");
        while (q.size() != 1) {
            for (int i = 1; i < k + 1; i++) {
                if (i == k) {
                    sb.append(q.poll()).append(", ");
                } else {
                    q.offer(q.poll());
                }
            }
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
