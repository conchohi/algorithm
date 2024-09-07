package greedy;

import java.io.*;
import java.util.*;

public class Baekjoon11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = n-1; i >= 0; i--) {
            if(k >= coins[i]){
                answer += k/coins[i];
                k = k % coins[i];

            }
        }
        System.out.println(answer);

    }
}
