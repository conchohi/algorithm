package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11724 {
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int answer = 0;

        List<Integer>[] graph = new List[n+1];

        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                answer++;
                dfs(graph, i, visited);
            }
        }

        System.out.println(answer);

    }
    public static void dfs(List<Integer>[] graph, int start, boolean[] visited){
        if(visited[start]){
            return;
        }
        visited[start] = true;
        for (Integer i : graph[start]) {
            dfs(graph, i, visited);
        }
    }
}
