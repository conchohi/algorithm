package 그래프.최단거리;

import java.util.*;
import java.io.*;

public class BellmanFord {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][3];
        long[] degrees = new long[N+1];

        degrees[1] = 0;
        for(int i = 2; i <= N; i++){
            degrees[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[i] = new int[]{s,e,w};
        }

        for(int i = 0; i < N-1; i++){
            for(int[] edge : graph){
                if(degrees[edge[0]] != Integer.MAX_VALUE && degrees[edge[1]] > degrees[edge[0]] + edge[2]){
                    degrees[edge[1]] = degrees[edge[0]] + edge[2];
                }
            }
        }
        boolean isMinusCycle = false;
        for(int[] edge : graph){
            if(degrees[edge[0]] != Integer.MAX_VALUE && degrees[edge[1]] > degrees[edge[0]] + edge[2]){
                isMinusCycle = true;
            }
        }

        if(isMinusCycle){
            System.out.println(-1);
        } else{
            for(int i = 2; i <= N; i++){
                if(degrees[i] == Integer.MAX_VALUE){
                    System.out.println(-1);
                } else {
                    System.out.println(degrees[i]);
                }
            }
        }}
}
