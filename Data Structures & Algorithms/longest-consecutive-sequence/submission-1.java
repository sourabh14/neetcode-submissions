class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return 0;

        int[] lis = new int[n];
        
        Arrays.fill(lis, 1);
        int ans = 1;
        
        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[j] == (nums[i] -1)) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            ans = Math.max(ans, lis[i]);
        }
        
        return ans;
    }
}
