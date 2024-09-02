package 정렬;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {100, 55, 41, 23, 47, 1, 11, 7, 9, 32, 64};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int startIdx, int endIdx){
        if(startIdx >= endIdx){
            return;
        }

        int pivot = arr[endIdx];
        int left = startIdx;
        int right = endIdx - 1;

        while (left <= right){
            while (left < endIdx && arr[left] < pivot){
                left++;
            }
            while (right >= startIdx && arr[right] > pivot){
                right--;
            }
            if(left < right){
                swap(arr, left, right);
            } else {
                swap(arr, left, endIdx);
            }
        }

        sort(arr, startIdx, left-1);
        sort(arr, left+1, endIdx);
    }


    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
