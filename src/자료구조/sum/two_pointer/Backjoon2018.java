package 자료구조.sum.two_pointer;

import java.util.Scanner;

public class Backjoon2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;

        int start = 1;
        int end = 1;

        int answer = 1;

        while(end <= n) {
            if(sum < n){
                sum += end;
                end++;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else{
                answer++;
                sum += end;
                end++;
            }
        }

        System.out.println(answer);
    }
}
