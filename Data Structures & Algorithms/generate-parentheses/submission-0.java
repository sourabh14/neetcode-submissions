class Solution {
    public void generate(int opening, int closing, char[] curr, int indx, List<String> ans) {
        if (indx == curr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<curr.length; i++) sb.append(curr[i]);
            ans.add(sb.toString());
            return;
        }

        if (opening == closing) {
            // only opening bracket possible
            curr[indx] = '(';
            generate(opening+1, closing, curr, indx+1, ans);
        } else if (opening > closing) {
            if (opening == (curr.length/2)) {
                // only closing possible
                curr[indx] = ')';
                generate(opening, closing+1, curr, indx+1, ans);
            } else {
                // opening and closing possible
                curr[indx] = '(';
                generate(opening+1, closing, curr, indx+1, ans);
                curr[indx] = ')';
                generate(opening, closing+1, curr, indx+1, ans);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        char[] curr = new char[2*n];
        List<String> ans = new ArrayList<>();
        generate(0, 0, curr, 0, ans);
        return ans;
    }
}
