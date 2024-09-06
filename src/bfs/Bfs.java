package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3}, {5,6}, {4}, {6}, {}, {}};
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[6+1];
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);
            for (int b : graph[current]) {
                if(!visited[b]){
                    queue.offer(b);
                    visited[b] = true;
                }
            }
        }
    }
}
