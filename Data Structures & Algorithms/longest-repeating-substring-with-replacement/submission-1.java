class Element {
    char val;
    int freq;

    public Element(char val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        Map<Character, Integer> freqMap = new HashMap<>();
        int ans = 0;

        for (int l=0, r=0; r<s.length(); r++) {
            // Add element at r
            Character ch = s.charAt(r);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            priorityQueue.add(new Element(ch, freqMap.get(ch)));

            // Remove stale elements so that top element is correct
            while (priorityQueue.peek().freq != freqMap.get(priorityQueue.peek().val)) priorityQueue.remove();
            
            // window size - max freq should be <= k
            for (; ((r-l+1) - priorityQueue.peek().freq) > k; l++) {
                // Remove element l
                ch = s.charAt(l);
                freqMap.put(ch, freqMap.get(ch) - 1);
                priorityQueue.add(new Element(ch, freqMap.get(ch)));
                
                // Remove stale elements
                while (priorityQueue.peek().freq != freqMap.get(priorityQueue.peek().val)) priorityQueue.remove();
            }
            
            ans = Math.max(ans, (r-l+1));
        }
        
        return ans;
    }
}
