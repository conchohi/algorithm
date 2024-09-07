package 소수;

import java.util.Scanner;

public class Baekjoon1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] isPrime = new boolean[m+1];

        for (int i = 2; i <= m; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if(!isPrime[i]){
                continue;
            }
            for (int j = (i*i); j <= m; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = n; i <= m; i++) {
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }
}
