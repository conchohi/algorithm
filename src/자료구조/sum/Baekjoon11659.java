package 자료구조.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
        // 1초 이내 -> 10^8 이하 연산
        // O(n^2) 이면 실패
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        //수의 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] rangeSum = new int[n+1];
        //M개의 입력
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            rangeSum[i] = Integer.parseInt(stringTokenizer.nextToken()) + rangeSum[i-1];
        }

        for (int k = 0; k < m; k++) {
            stringTokenizer = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(rangeSum[j] - rangeSum[i-1]);
        }
    }
}
