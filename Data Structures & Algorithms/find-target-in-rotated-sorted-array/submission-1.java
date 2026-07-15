class Solution {
    public int getPivot(int[] nums) {
        // base case
        int n = nums.length;
        if ((n == 1) || (nums[0] < nums[n-1])) return 0;

        int l = 0, r = n-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (nums[mid] >= nums[0]) l = mid+1;
            else r = mid;
        }
        return l;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < target) l = mid+1;
            else r = mid;
        }
        return (nums[l] == target) ? l : -1;
    }

    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int s1 = binarySearch(nums, 0, pivot-1, target);
        return (s1 == -1) ? binarySearch(nums, pivot, nums.length-1, target) : s1;
    }
}
