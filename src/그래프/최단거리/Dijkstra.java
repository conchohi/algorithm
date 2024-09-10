package 그래프.최단거리;

import java.io.*;
import java.util.*;

class Edge {
    int node;
    int weight;

    public Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class Dijkstra {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] degree = new int[V+1];

        int start = Integer.parseInt(bf.readLine());

        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
            degree[i] = Integer.MAX_VALUE;
        }

        degree[start] = 0;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e,w));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int s = queue.poll();
            visited[s] = true;

            for(Edge i : graph[s]){
                int move = degree[s] + i.weight;
                if(degree[i.node] > move){
                    degree[i.node] = move;
                }
            }

            int min = Integer.MAX_VALUE;
            int minNode = -1;

            for(int j = 1; j <= V; j++){
                if(!visited[j] && min > degree[j]){
                    min = degree[j];
                    minNode = j;
                }
            }
            if(minNode == -1){
                break;
            }
            queue.offer(minNode);
        }
        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                System.out.println("INF");
            } else{
                System.out.println(degree[i]);
            }
        }

    }
}
