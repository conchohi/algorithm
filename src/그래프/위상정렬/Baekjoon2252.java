package 그래프.위상정렬;

import java.io.*;
import java.util.*;

public class Baekjoon2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        int[] D = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            D[e]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(D[i] == 0){
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int p = queue.poll();
            sb.append(p).append(" ");
            for(int i : graph[p]){
                D[i]--;
                if(D[i] == 0){
                    queue.offer(i);
                }
            }
        }
        System.out.println(sb);
    }
}
