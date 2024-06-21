package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println( removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[count]){
                nums[++count]=nums[i];
            }
        }
        return count+1;
    }
}
