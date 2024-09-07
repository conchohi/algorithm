package 이진탐색;

public class BinarySearch {
    public static int[] arr = new int[]{1, 4, 5, 7, 11, 14, 17, 20, 22, 26, 31, 38, 42, 49, 55, 62};
    public static boolean isExist;
    public static void main(String[] args) {
        binarySearch(0, arr.length-1, 62);
        if(isExist){
            System.out.println("존재");
        } else {
            System.out.println("존재하지 않음");
        };
    }

    private static void binarySearch(int start, int end, int i) {
        if(start > end){
            return;
        }
        int middle = (start + end) / 2;
        if(arr[middle] == i){
            isExist = true;
        } else if (arr[middle] > i) {
            binarySearch(start, middle-1, i);
        } else {
            binarySearch(middle+1, end, i);
        }
    }
}
