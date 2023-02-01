package org.example.queue.BOJ1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            LinkedList<int[]> q = new LinkedList<>();

            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            int targetIdx = Integer.parseInt(s[1]);

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll(); // [0,5]
                boolean curIsMax = true;

                for (int j = 0; j < q.size(); j++) {
                    if (cur[1] < q.get(j)[1]) {

                        q.offer(cur);

                        for (int l = 0; l < j; l++) {
                            q.offer(q.poll());
                        }
                        curIsMax = false;
                        break;
                    }
                }
                if (curIsMax) {
                    count++;
                    if (cur[0] == targetIdx) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
