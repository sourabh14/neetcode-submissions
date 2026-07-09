class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0, max = prices[n-1];
        for (int i=n-1; i>=0; i--) {
            ans = Math.max(ans, (max - prices[i]));
            max = Math.max(max, prices[i]);
        }
        return ans;
    }
}
