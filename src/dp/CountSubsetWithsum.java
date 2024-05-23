package dp;

import java.util.Arrays;

public class CountSubsetWithsum {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println( subarraySum(arr,3));
    }
    public static int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return findp(nums.length-1,nums,k,dp);
    }

    private static int find(int i, int[] nums, int sum) {
        if(sum==0){
            return 1;
        }
        if(i==0){
            if (nums[i] == sum) return 1;
            else return 0;
        }
        int notPick = find(i-1,nums,sum);
        int pick = 0;
        if(sum>=nums[i]){
            pick = find(i-1,nums,sum-nums[i]);
        }
        return pick+notPick;
    }
    // memorization
    private static int findp(int i, int[] nums, int sum,int[] dp) {
        if(sum==0){
            return 1;
        }
        if(i==0){
            if (nums[i] == sum) return 1;
            else return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int notPick = findp(i-1,nums,sum,dp);
        int pick = 0;
        if(sum>=nums[i]){
            pick = findp(i-1,nums,sum-nums[i],dp);
        }
        return dp[i] = pick+notPick;
    }
}
