package org.example.queue.BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            q.add(i);
        }

        while (true) {
            if (q.size() == 1) {
                System.out.println(q.peek());
                break;
            }
            if (count % 2 != 0) {
                q.poll();
            } else {
                q.add(q.peek());
                q.poll();
            }
            count++;
        }
    }
}