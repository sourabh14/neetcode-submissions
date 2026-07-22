class KthLargest {
    Queue<Integer> pQueue;
    int capacity;

    public KthLargest(int k, int[] nums) {
        pQueue = new PriorityQueue<>();
        capacity = k;
        for (int num: nums) {
            if (pQueue.size() == capacity) {
                if (num > pQueue.element()) {
                    pQueue.remove();
                    pQueue.add(num);
                }
            } else {
                pQueue.add(num);
            }
        }
    }

    public int add(int val) {
        if (pQueue.size() == capacity) {
            if (val > pQueue.element()) {
                pQueue.remove();
                pQueue.add(val);
            }
        } else {
            pQueue.add(val);
        }
        return pQueue.element();
    }
}