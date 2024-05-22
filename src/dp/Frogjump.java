package dp;

public class Frogjump {
    public static void main(String[] args) {
        int[] a = {0,2,5,6,7};
        System.out.println(maxJump(a));
    }
    public static int maxJump(int[] stones) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < stones.length; i++) {
            int fs = prev + Math.abs(stones[i]-stones[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = prev2 + Math.abs(stones[i]-stones[i-2]);
            }
            int curr = Math.min(fs,ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
