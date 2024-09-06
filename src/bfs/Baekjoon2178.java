package bfs;

import java.io.*;
import java.util.*;

public class Baekjoon2178 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int n;
    public static int m;
    public static boolean[][] visited;
    public static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++){
            String row = bf.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j+1] = row.charAt(j) - '0';
            }
        }

        bfs(1,1);
        System.out.println(graph[n][m]);
    }
    public static void bfs(int s, int e){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{s, e});
        visited[s][e] = true;

        while(!queue.isEmpty()){
            int[] start = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = start[0] + dx[i];
                int y = start[1] + dy[i];
                if(x > 0 && x <= n && y > 0 && y <= m){
                    if(graph[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                        graph[x][y] = graph[start[0]][start[1]] + 1;
                    }
                }
            }
        }
    }
}