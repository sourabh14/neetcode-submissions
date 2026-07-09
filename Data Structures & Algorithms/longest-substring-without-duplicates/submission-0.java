class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (int l=0, r=0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, (r-l+1));
        }
        
        return ans;
    }
}
