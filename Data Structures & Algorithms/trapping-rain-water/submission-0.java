class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 1) return 0;
        
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        for (int i=1; i<n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        maxRight[n-1] = 0;
        for (int i=n-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        
        int ans = 0;
        for (int i=0; i<n; i++) {
            int val = Math.min(maxLeft[i], maxRight[i]);
            ans += ((val > height[i]) ? (val - height[i]) : 0);
        }
        return ans;
    }
}
