class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        int[] ans = new int[2];
        for (int i=0; i<nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                int j = numToIndex.get(target - nums[i]);
                if (i != j) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
