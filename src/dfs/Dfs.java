package dfs;

import java.util.Stack;

public class Dfs {
    public static void main(String[] args) {
        int n = 6;
        // 인접 리스트
        int[][] graph = {{}, {2,3}, {5,6}, {4}, {6} , {}, {}};

        // 방문 배열 -> 방문 시 true로 변경
        boolean[] visited = new boolean[n+1];

        // 스택에 추가
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        visited[1] = true;

        while(!stack.isEmpty()){
            int i = stack.pop();
            System.out.println(i);
            for(int node : graph[i]){
                if(visited[node]){
                    continue;
                }
                visited[node] = true;
                stack.push(node);
            }

        }



    }
}
