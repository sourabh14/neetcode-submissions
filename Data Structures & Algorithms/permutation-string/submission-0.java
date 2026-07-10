class Solution {
    public boolean equalFreq(int[] freq1, int[] freq2) {
        for (int i=0; i<26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        for (char ch: s1.toCharArray()) {
            freqS1[ch - 'a']++;
        }

        for (int l=0, r=0; r<s2.length(); r++) {
            // Add r
            char ch = s2.charAt(r);
            freqS2[ch - 'a']++;
            for (; (freqS2[ch - 'a'] > freqS1[ch - 'a']); l++) {
                // Remove l
                char lch = s2.charAt(l);
                freqS2[lch - 'a']--;
            }
            // Check if frequecies are equal
            if (equalFreq(freqS1, freqS2)) {
                return true;
            }
        }
        return false;
    }
}
