class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            k %=n;
        }
        reverse(nums,0,n-1-k);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    public void reverse(int[] nums,int left ,int right){
        while(left<right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    // for(int i=0;i<k;i++){
    //     int last = nums[nums.length-1];
    //     for(int j=nums.length-1;j>0;j--){
    //         nums[j]=nums[j-1];
    //     }
    //     nums[0]=last;
    // }
    }
}
