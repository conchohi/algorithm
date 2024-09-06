package dfs;

import java.io.*;
import java.util.*;

public class Baekjoon13023 {
    public static int n;
    public static int m;
    public static boolean[] visited;
    public static List<Integer>[] graph;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        graph = new List[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for (int i = 0; i < n; i++) {
            if(answer != 1){
                dfs(i, 1);
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int start, int depth){
        visited[start] = true;
        if(depth == 5){
            answer = 1;
            return;
        }

        for (int i : graph[start]) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
        visited[start] = false;
    }
}
