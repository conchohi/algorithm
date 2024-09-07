package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1920 {
    public static int[] arr;
    public static int[] targets;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(bf.readLine());
        targets = new int[m];
        answer = new int[m];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            binarySearch(targets[i], i);
        }
        for (int i : answer) {
            System.out.println(i);
        }

    }

    private static void binarySearch(int target, int i) {
        binarySearch(target, i,0, arr.length-1);
    }

    private static void binarySearch(int target, int i, int start, int end) {
        if(start > end){
            return;
        }
        int middle = (start + end) / 2;

        if(arr[middle] == target){
            answer[i] = 1;
        } else if (arr[middle] > target) {
            binarySearch(target, i, start, middle-1);
        } else {
            binarySearch(target, i, middle+1, end);
        }
    }

}
