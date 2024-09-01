package 자료구조.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringBuffer stringBuffer = new StringBuffer();

        stack.push(0);

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }
        int addNum = 1;

        for (int num : nums) {
            if (num >= addNum) {
                while (addNum <= num) {
                    stack.push(addNum++);
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            } else {
                int top = stack.pop();
                if(top != num){
                    System.out.println("NO");
                    return;
                }
                stringBuffer.append("-\n");
            }
        }
        System.out.println(stringBuffer);
    }
}
