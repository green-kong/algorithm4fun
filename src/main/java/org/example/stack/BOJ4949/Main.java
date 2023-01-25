package org.example.stack.BOJ4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<String> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String sentence = br.readLine();
            if(sentence.equals(".")){
                break;
            }
            st.clear();

            for (int i = 0; i < sentence.length(); i++) {
                String character = String.valueOf(sentence.charAt(i));
                if (character.equals("(") || character.equals("[")) {
                    st.push(character);
                } else if (character.equals(")")) {
                    if (st.size() == 0 || !st.peek().equals("(")) {
                        st.push(character);
                        break;
                    }
                    st.pop();
                } else if (character.equals("]")) {
                    if (st.size() == 0 || !st.peek().equals("[")) {
                        st.push(character);
                        break;
                    }
                    st.pop();
                }
            }
            System.out.println(st.size() > 0 ? "no" : "yes");
        }
    }
}
