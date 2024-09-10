package 정수론;

public class Euclidean {
    public static void main(String[] args) {
        int n = 192;
        int m = 270;

        System.out.println(gcd(n,m));
    }
    public static int gcd(int n1, int n2){
        if(n2 > n1){
            return gcd(n2, n1);
        }
        int remain = n1 % n2;

        if(remain == 0){
            return n2;
        } else {
            return gcd(n2, remain);
        }
    }
}
