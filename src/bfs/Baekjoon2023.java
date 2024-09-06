package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2023 {
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        bfs(0);
    }

    public static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(num);


        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int i = 0; i <= 9; i++) {
                int x = current * 10 + i;
                if(isDecimal(x)){
                    if(x >= Math.pow(10, n-1)){
                        System.out.println(x);
                    } else {
                        queue.offer(x);
                    }
                }
            }

        }
    }

    public static boolean isDecimal(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
