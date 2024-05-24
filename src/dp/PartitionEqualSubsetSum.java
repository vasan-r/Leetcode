package dp;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 != 0){
            return false;
        }
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        return findp(nums.length-1, nums,target,dp);
    }
// recursion
    private static boolean find(int i,int[] nums, int target) {
        if(i==0){
            return nums[i] == target;
        }
        boolean notPick = find(i-1,nums,target);
        boolean pick = false;
        if(nums[i]<=target){
            pick = find(i-1,nums,target-nums[i]);
        }
        return pick || notPick;
    }
    // memorization
    private static boolean findp(int i,int[] nums, int target,int[][] dp) {
        if(i==0){
            return nums[i] == target;
        }
        if(dp[i][target] != 0){
            return dp[i][target]==2;
        }
        boolean notPick = findp(i-1,nums,target,dp);
        boolean pick = false;
        if(nums[i]<=target){
            pick = findp(i-1,nums,target-nums[i],dp);
        }
        dp[i][target] = (pick || notPick) ? 2:1;
        return pick || notPick;
    }
}
