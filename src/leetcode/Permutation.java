package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        find(ans,list,freq,nums);
        return ans;
    }
    private static void find(List<List<Integer>> ans,List<Integer> list,boolean[] freq,int[] nums){
        if(list.size()== nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!freq[i]){
                freq[i]=true;
                list.add(nums[i]);
                find(ans,list,freq,nums);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}
