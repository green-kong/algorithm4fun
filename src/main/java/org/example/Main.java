package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] depth = new int[n];
        int[] maxBehind = new int[n];
        int[] maxAhead = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = sc.nextInt();
        }

        for (int i = n - 1; i > 0; i--) {
            if (depth[i] < depth[i - 1]) {
                maxBehind[i - 1] = Math.max(maxBehind[i - 1], maxBehind[i] + 1);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (depth[i] < depth[i + 1]) {
                maxAhead[i + 1] = Math.max(maxAhead[i + 1], maxAhead[i] + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            int command = sc.nextInt();
            if (command == 0) {
                int maxSignals = 0;
                for (int j = 0; j < n; j++) {
                    maxSignals = Math.max(maxSignals, maxBehind[j] + maxAhead[j]);
                }
                System.out.println(maxSignals);
            } else {
                int temp = depth[command - 1];
                depth[command - 1] = depth[command];
                depth[command] = temp;

                if (command > 1 && depth[command - 2] < depth[command - 1]) {
                    maxBehind[command - 2] = 0;
                    for (int j = command - 1; j < n; j++) {
                        if (depth[j] < depth[j - 1]) {
                            maxBehind[j - 1] = Math.max(maxBehind[j - 1], maxBehind[j] + 1);
                        } else {
                            break;
                        }
                    }
                }

                if (command < n && depth[command - 1] < depth[command]) {
                    maxAhead[command] = 0;
                    for (int j = command - 1; j >= 0; j--) {
                        if (depth[j] < depth[j + 1]) {
                            maxAhead[j + 1] = Math.max(maxAhead[j + 1], maxAhead[j] + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
