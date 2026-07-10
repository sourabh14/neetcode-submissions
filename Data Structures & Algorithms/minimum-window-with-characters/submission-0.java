class Solution {
    private int getIndex(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';           // 0 - 25
        }
        return ch - 'a' + 26;          // 26 - 51
    }

    private boolean freqGte(int[] freqS, int[] freqT) {
        for (int i=0; i<52; i++) {
            if (freqS[i] < freqT[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] freqT = new int[52];
        int[] freqS = new int[52];

        int ansl = -1, ansr = -1;
        int ansWidth = Integer.MAX_VALUE;

        for (char ch: t.toCharArray()) {
            freqT[getIndex(ch)]++;
        }

        for (int l=0, r=0; r<s.length(); r++) {
            // Add r
            char ch = s.charAt(r);
            freqS[getIndex(ch)]++;

            // check if condition satisfies
            for (; freqGte(freqS, freqT); l++) {
                if ((r - l + 1) < ansWidth) {
                    ansl = l; ansr = r;
                    ansWidth = ansr - ansl + 1;
                }

                // increase l
                ch = s.charAt(l);
                freqS[getIndex(ch)]--;
            }
        }
        
        return (ansWidth == Integer.MAX_VALUE) ? "" : s.substring(ansl, ansr+1);
    }
}
