package 그래프;

import java.io.*;
import java.util.*;


public class Baekjoon1707 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] color;
    static String answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new List[V+1];
            visited = new boolean[V+1];
            color = new int[V+1];
            answer = "YES";
            for(int j = 1; j <= V; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for(int j = 1; j <= V; j++){
                if(answer.equals("NO")){
                    break;
                }
                dfs(j);
            }
            System.out.println(answer);
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int end : graph[start]){
            if(!visited[end]){
                color[end] = (color[start] + 1) % 2;
                dfs(end);
            } else {
                if(color[start] == color[end]){
                    answer = "NO";
                }
            }
        }
    }
}
