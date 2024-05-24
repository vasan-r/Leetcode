package dp;

public class SubsetSumEqualToK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 7;
        boolean[][] dp = new boolean[arr.length][target+1];
        System.out.println(subsetSumT(arr,target,dp));
    }
// recursion.
    private static boolean subsetSum(int index,int[] arr, int target) {
        if(index==0){
            return arr[0]==target;
        }
        if(target==0)
            return true;
        boolean np = subsetSum(index-1,arr,target);
        boolean p = false;
        if(arr[index]<=target){
            p = subsetSum(index-1,arr,target-arr[index]);
        }
        return p || np;
    }
    // memorization
    private static boolean subsetSumDp(int index,int[] arr, int target,int[][] dp) {
        if(index==0){
            return arr[0]==target;
        }
        if(target==0)
            return true;
        if(dp[index][target] != 0){
            return dp[index][target]==2;
        }
        boolean np = subsetSumDp(index-1,arr,target,dp);
        boolean p = false;
        if(arr[index]<=target){
            p = subsetSumDp(index-1,arr,target-arr[index],dp);
        }
        dp[index][target]=(p||np)?2:1;
        return p || np;
    }
    //tabulation
    private static boolean subsetSumT(int[] arr, int target,boolean[][] dp) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }
        if(arr[0]>=0 && arr[0]<=target)
            dp[0][arr[0]]=true;
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean np = dp[i-1][t];
                boolean p = false;
                if(arr[i]<=t){
                    p = dp[i-1][t-arr[i]];
                }
                dp[i][t]=p||np;
            }
        }
        return dp[n-1][target];
    }
}
