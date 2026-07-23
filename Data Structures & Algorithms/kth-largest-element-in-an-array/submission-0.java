class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int num: nums) {
            if (pQueue.size() == k) {
                if (num > pQueue.element()) {
                    pQueue.remove();
                    pQueue.add(num);
                }
            } else {
                pQueue.add(num);
            }
        }
        return pQueue.element();
    }
}
