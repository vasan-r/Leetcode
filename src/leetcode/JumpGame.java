package leetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
    public static boolean canJump(int[] nums) {
        int maxI = 0;
        for (int i = 0; i < nums.length; i++) {

            if (maxI>=i){
                maxI = Math.max(maxI,nums[i]+i);
            }else {
                return false;
            }
            if(maxI>=nums.length){
                return true;
            }
        }return true;
    }
}
