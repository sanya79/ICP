class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=nums[0];
        
        int opt1=nums[n-1]*nums[n-2]*nums[n-3];
        int opt2=nums[0]*nums[1]*nums[n-1];
        return Math.max(opt1,opt2); 
    }
}