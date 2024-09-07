package 소수;

import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(!isPrime[i]){
                continue;
            }
            for (int j = i*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 0; i <= n; i++) {
            if(isPrime[i]){
                System.out.println(i);
                answer++;
            }
        }
        System.out.println("총 소수의 개수 : " + answer);
    }
}
