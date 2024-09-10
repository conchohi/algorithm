package 정수론;

public class Eulerphi {
    public static void main(String[] args) {
        int n = 100;

        int[] nums = new int[n+1];

        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if(nums[i] == i){
                for (int j = i; j <= n; j += i) {
                    nums[j] = nums[j] - nums[j]/i;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "의 서로소 개수 : " + nums[i]);
        }
    }
}
