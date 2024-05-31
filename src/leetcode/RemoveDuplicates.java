class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if((nums[index] == nums[i]) && count<2){
                nums[++index] = nums[i];
                count++;
            }else if(nums[index] != nums[i]){
                count = 1;
                nums[++index] = nums[i];
            }
        }
        return index+1;
        
    }
}
