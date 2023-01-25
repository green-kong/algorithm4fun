package org.example.stack.BOJ1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> st = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > current) {
                for (int j = current + 1; j <= value; j++) {
                    st.add(j);
                    sb.append("+").append("\n");
                }
                current = value;
                st.pop();
                sb.append("-").append("\n");
            } else if (value < current) {
                if (value == st.peek()) {
                    st.pop();
                    sb.append("-").append("\n");
                }else{
                    System.out.println("NO");
                    return;
                }
            }

        }
        System.out.println(sb.toString());
    }
}
