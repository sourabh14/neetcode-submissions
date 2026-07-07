class Solution {
    class Element {
        private int val;
        private int freq;

        public Element(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            Element curr = new Element(entry.getKey(), entry.getValue());
            if (priorityQueue.size() == k) {
                Element top = priorityQueue.element();
                if (curr.freq > top.freq) {
                    priorityQueue.remove();
                    priorityQueue.add(curr);
                }
            } else {
                priorityQueue.add(curr);
            }
        }
        
        int n = priorityQueue.size();
        int[] ans = new int[n];

        int i=0;
        for (Element e : priorityQueue) {
            ans[i] = e.val;
            i++;
        }
        
        return ans;
    }
}
