class Solution {
    public int findMin(int[] nums) {
        // base case
        int n = nums.length;
        if ((n == 1) || (nums[0] < nums[n-1])) return nums[0];
        
        int l = 0, r = n-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (nums[mid] >= nums[0]) l = mid+1;
            else r = mid;
        }
        return nums[l];
    }
}
