package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = bf.readLine().toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            int max = i;
            for (int j = i+1; j < charArray.length; j++) {
                if(charArray[max] < charArray[j] ){
                    max = j;
                }
            }
            if(max != i){
                char temp = charArray[i];
                charArray[i] = charArray[max];
                charArray[max] = temp;
            }
        }
        System.out.println(charArray);
    }
}
