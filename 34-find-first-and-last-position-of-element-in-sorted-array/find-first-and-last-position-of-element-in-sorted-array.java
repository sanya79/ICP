class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    public int findFirst(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int index = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] >= target) {
                end = mid - 1; 
            } else {
                st = mid + 1; 
            }
            if (nums[mid] == target) index = mid; 
        }
        return index;
    }

    public int findLast(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int index = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] <= target) {
                st = mid + 1; 
            } else {
                end = mid - 1; 
            }
            if (nums[mid] == target) index = mid; 
        }
        return index;
    }
}
