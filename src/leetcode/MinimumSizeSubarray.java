package leetcode;

public class MinimumSizeSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {

                int left = 0;
                int right = 0;
                int sum = 0;
                int min = Integer.MAX_VALUE;
                while(right<nums.length){
                    sum += nums[right];
                    while(sum>=target){
                        sum -= nums[left];
                        min = Math.min(min,right-left+1);
                        left++;
                    } right++;
                }
                if(min==Integer.MAX_VALUE){
                    return 0;
                }
                return min;
            }

}
