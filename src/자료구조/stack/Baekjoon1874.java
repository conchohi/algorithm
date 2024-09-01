package 자료구조.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        stack.push(0);

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        int start = 1;

        for (int num : nums) {
            if(num > stack.peek()){
                while(start <= num){
                    stack.push(start);
                    answer.add("+");
                    if(start == num){
                        answer.add("-");
                        stack.pop();
                    }
                    start++;
                }
            } else if(num == stack.peek()){
                stack.pop();
                answer.add("-");
            } else{
                System.out.println("NO");
                return;
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
