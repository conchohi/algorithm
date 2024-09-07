package greedy;

import java.util.Scanner;

public class Baekjoon1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        String[] strs = expression.split("-");

        int answer = 0;
        for (int i = 0; i < strs.length; i++) {
            int sum = strSum(strs[i]);
            if(i == 0){
                answer += sum;
            } else{
                answer -= sum;
            }
        }
        System.out.println(answer);
    }

    public static int strSum(String str){
        String[] strs = str.split("[+]");
        int sum = 0;
        for (String s : strs) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
