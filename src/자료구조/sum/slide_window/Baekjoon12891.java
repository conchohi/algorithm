package 자료구조.sum.slide_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        char[] dnaArr = bf.readLine().toCharArray();

        stringTokenizer = new StringTokenizer(bf.readLine());

        int[] ACGT = new int[4];
        int[] counts = new int[4];

        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < P; i++){
            char dna = dnaArr[i];
            count(counts, dna);
        }

        int start = 0;
        while (true){
            if(comparison(ACGT, counts)){
                answer++;
            }
            if(start + P >= S){
                break;
            }
            minus(counts, dnaArr[start]);
            count(counts, dnaArr[start+P]);
            start++;
        }

        System.out.println(answer);



    }

    public static void count(int[] counts, char dna){
        switch (dna){
            case 'A' : counts[0]++; break;
            case 'C' : counts[1]++; break;
            case 'G' : counts[2]++; break;
            case 'T' : counts[3]++; break;
        }
    }
    public static void minus(int[] counts, char dna){
        switch (dna){
            case 'A' : counts[0]--; break;
            case 'C' : counts[1]--; break;
            case 'G' : counts[2]--; break;
            case 'T' : counts[3]--; break;
        }
    }
    public static boolean comparison(int[] ACGT, int[] counts){
        return ACGT[0] <= counts[0] && ACGT[1] <= counts[1] && ACGT[2] <= counts[2] && ACGT[3] <= counts[3];
    }
}
