class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int nMaxFreqElement = 0;
        for (char task: tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }
        
        for (int i=0; i<26; i++) {
            if (freq[i] == maxFreq) {
                nMaxFreqElement++;
            }
        }
        
        return Math.max((tasks.length), ((n+1) * (maxFreq-1) + nMaxFreqElement));
    }
}
