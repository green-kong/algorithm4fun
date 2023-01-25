package org.example.BOJ1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int answer = 0;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int row, int col, int count) {
        int idx = map[row][col] - 'A';
        if (visited[idx]) {
            answer = Math.max(answer, count);
            return;
        }

        visited[idx] = true;
        int newCount = count + 1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && nx < R
                    && ny >= 0 && ny < C) {
                dfs(nx, ny, newCount);
            }
        }
        visited[idx] = false;
    }
}