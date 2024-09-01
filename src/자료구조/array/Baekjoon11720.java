package 자료구조.array;

import java.io.*;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int answer = 0;

        String numbers = bf.readLine();

        for (char c : numbers.toCharArray()) {
            answer += c - '0';
        }
        System.out.println(answer);
    }
}
