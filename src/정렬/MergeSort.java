package 정렬;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {100, 55, 41, 23, 47, 1, 11, 7, 9, 32, 64};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {
        if(start == end){
            return;
        }

        int middle = (start+end)/2;

        sort(arr, start, middle);
        sort(arr, middle + 1, end);

        merge(arr, start, middle, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int size = end - start + 1;
        int[] sorted = new int[size];

        int i = start;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end){
            if(arr[i] > arr[j]){
                sorted[k++] = arr[j++];
            } else if(arr[j] > arr[i]){
                sorted[k++] = arr[i++];
            }
        }
        while(i <= middle){
            sorted[k++] = arr[i++];
        }

        while(j <= end){
            sorted[k++] = arr[j++];
        }

        for (int l = 0; l < size; l++) {
            arr[start+l] = sorted[l];
        }
    }
}
