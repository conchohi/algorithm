package sum;

public class RangeSum {
    public static void main(String[] args) {
        int n = 20;
        long[] A = new long[n];
        long[] S = new long[n];

        for (int i = 1; i < n; i++) {
            A[i] = (int)(Math.random()*Integer.MAX_VALUE);
            S[i] = A[i] + S[i-1];
            System.out.println("A[" + i + "] : " + A[i] );
            System.out.println("S[" + i + "] : " + S[i] );
        }

        // 5 ~ 15 까지 구간 합
        System.out.println("5 ~ 15 까지 구간 합 : " + (S[15] - S[4]));
    }
}
