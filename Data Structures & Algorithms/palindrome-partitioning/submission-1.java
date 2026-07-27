class Solution {
    public static void generate(String s, int indx, boolean[][] isPalindrome, List<String> curr, List<List<String>> ans) {
        if (indx == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int size=1; size <= (s.length()-indx); size++) {
            int i=indx, j=(indx+size-1);
            if (isPalindrome[i][j]) {
                curr.add(s.substring(i, j+1));
                generate(s, j+1, isPalindrome, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i=0; i<n; i++) isPalindrome[i][i] = true;

        for (int size=2; size<=n; size++) {
            for (int i=0, j=(size-1); j<n; i++, j++) {
                if (size == 2) isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                else isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && (isPalindrome[i+1][j-1]);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        generate(s, 0, isPalindrome, new ArrayList<>(), ans);
        return ans;
    }
}
