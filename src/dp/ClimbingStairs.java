package dp;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(find(n));
    }

    private static int find(int n) {
        if(n==0)
            return 1;
        int l = find(n-1);
        int r = 0;
        if(n>1)
            r = find(n-2);
        return l+r;
    }
//    private static int finddpT(int n,int[] dp) {
//
//    }
    private static int finddp(int n,int[] dp) {
        if(n==0)
            return 1;
        if(dp[n] != 0)
            return dp[n];
        int l = finddp(n-1,dp);
        int r = 0;
        if(n>1)
            r = finddp(n-2,dp);
        return dp[n] = l+r;
    }
}
