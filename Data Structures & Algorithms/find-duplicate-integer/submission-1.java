class Solution {
    public int findDuplicate(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int indx = Math.abs(nums[i]);
            if (nums[indx-1] < 0) return indx;
            else nums[indx-1] = -nums[indx-1];
        }
        return 0;
    }
}
