package org.example.deque.BOJ2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> d = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            d.offer(new Balloon(i + 1, Integer.parseInt(values[i])));
        }

        Balloon target = d.pollFirst();
        sb.append(target.index).append(" ");

        while (d.size() > 1) {
            int value = target.value;

            if (value > 0) {
                for (int i = 1; i < value + 1; i++) {
                    if (i != value) {
                        d.offerLast(d.pollFirst());
                    } else {
                        target = d.pollFirst();
                        sb.append(target.index).append(" ");
                    }
                }
            } else {
                for (int i = -1; i > value - 1; i--) {
                    if (i != value) {
                        d.offerFirst(d.pollLast());
                    } else {
                        target = d.pollLast();
                        sb.append(target.index).append(" ");
                    }
                }
            }
        }

        sb.append(d.poll().index);
        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int value;

        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
