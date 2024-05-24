package dp;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] arr = {-36,36};
        System.out.println(minimumDifference(arr));
    }

    public static int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return find(nums, sum);
    }

    private static int find(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum && nums[0] >=0) {
            dp[0][nums[0]] = true;
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= nums[i]) { // Ensure we don't access negative index
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || notTake;
            }
        }

        // Find the minimum difference
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n - 1][i]) {
                min = Math.min(min, Math.abs((sum - i) - i));
            }
        }
        return min;
    }
}
