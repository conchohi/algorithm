package 그래프.최단거리;

import java.io.*;
import java.util.*;

class Node {
    int toNode;
    int weight;

    public Node(int toNode, int weight){
        this.toNode = toNode;
        this.weight = weight;
    }
}

public class DijkstraV2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[V+1];
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
            graph[s].add(new Node(e,w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });

        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node s = queue.poll();
            if(visited[s.toNode]){
                continue;
            }
            visited[s.toNode] = true;

            for(Node i : graph[s.toNode]){
                int move = s.weight + i.weight;
                if(degree[i.toNode] > move){
                    degree[i.toNode] = move;
                    queue.offer(new Node(i.toNode, degree[i.toNode]));
                }
            }
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
