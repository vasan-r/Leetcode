package dp;

public class FindTargerSumWay {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        return find(nums.length-1, nums,target);
    }
    private static int find(int i,int[] nums, int target) {
        if(target==0){
            return 1;
        }
        if(i==0){
            return nums[i] == target ? 1 : 0;
        }
        int notPick = find(i-1,nums,target);
        int pick = 0;
        if(nums[i]<=target){
            pick = find(i-1,nums,target-nums[i]);
        }
        return pick + notPick;
    }
}
