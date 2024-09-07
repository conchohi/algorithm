package dfs;

import java.io.*;
import java.util.*;

public class Baekjoon1167 {
    public static List<int[]>[] graph;
    public static boolean[] visited;
    public static int v;
    public static int max;
    public static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(bf.readLine());

        graph = new List[v+1];
        visited = new boolean[v+1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int current = Integer.parseInt(st.nextToken());

            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node == -1){
                    break;
                }
                int length = Integer.parseInt(st.nextToken());
                graph[current].add(new int[]{node, length});
            }
        }
        dfs(1, 0);

        visited = new boolean[v+1];
        dfs(maxNode, 0);
        System.out.println(max);
    }
    private static void dfs(int i, int depth) {
        visited[i] = true;
        if(depth > max){
            maxNode = i;
            max = depth;
        }
        for (int[] node : graph[i]) {
            if(!visited[node[0]]){
                dfs(node[0], depth + node[1]);
            }
        }
    }
}
