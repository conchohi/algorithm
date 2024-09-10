package 그래프.유니온파인드;

import java.util.*;
import java.io.*;

public class Baekjoon1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());
            String question = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(question.equals("0")){
                union(x,y);
            } else if(question.equals("1")){
                if(find(x) == find(y)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }


    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y){
        int mainX= find(x);
        int mainY= find(y);
        int min = Math.min(mainX, mainY);
        parent[mainX] = min;
        parent[mainY] = min;
    }
}
