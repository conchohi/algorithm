package 자료구조.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int max = 0;
        double sum = 0;

        String[] scoresStr = bf.readLine().split(" ");
        for (String scoreStr : scoresStr) {
            int score = Integer.parseInt(scoreStr);
            if(max < score) max = score;
            sum += score;
        }


        System.out.println(sum / max * 100 / n);
    }
}
