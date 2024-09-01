package 자료구조.queue.priority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class Baekjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2)->{
           int firstAbs = Math.abs(o1);
           int secondAbs = Math.abs(o2);
           if(firstAbs == secondAbs){
               return o1 - o2;
           }
           return firstAbs - secondAbs;
        });


        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());

            if(num == 0){
                if(priorityQueue.isEmpty()){
                    stringBuffer.append("0\n");
                } else {
                    stringBuffer.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(num);
            }
        }
        System.out.println(stringBuffer);
    }
}
