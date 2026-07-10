class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i=0; i<k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            priorityQueue.add(nums[i]);
        }

        int n = nums.length;
        int[] ans = new int[n-k+1];

        ans[0] = priorityQueue.peek();

        for (int i=1, j=(i+k-1); j<n; i++, j++) {
            // remove i-1, add j
//            System.out.println("i = " + i + " j = " + j);
            freq.put(nums[i-1], freq.get(nums[i-1]) - 1);
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            priorityQueue.add(nums[j]);

            // Remove stale entries from priority queue
            while (freq.get(priorityQueue.peek()) == 0) {
//                System.out.println("Removing form pq = " + priorityQueue.peek());
                priorityQueue.remove();
            }

            ans[i] = priorityQueue.peek();
//            System.out.println("ans[i] = " + ans[i]);
        }

        return ans;
    }

}
