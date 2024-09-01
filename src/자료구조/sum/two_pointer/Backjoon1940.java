package 자료구조.sum.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[] materials = new int[n+1];

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            materials[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(materials);

        int start = 1;
        int end = n;
        int answer = 0;

        while (start != end){
            int sum = materials[start] + materials[end];
            if(sum < m){
                start++;
            } else if (sum > m) {
                end--;
            } else {
                answer++;
                start++;
                end--;
            }
        }
        System.out.println(answer);
    }
}
