package leetcode;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {

        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,3,num2,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (j>=0){
            if(i>=0 && nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));

    }
}
