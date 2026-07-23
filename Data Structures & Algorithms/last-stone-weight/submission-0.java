class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone: stones) pQueue.add(stone);
        
        while (pQueue.size() > 1) {
            int v1 = pQueue.remove();
            int v2 = pQueue.remove();
            if (v1 > v2) {
                pQueue.add(v1 - v2);
            }
        }
        
        return pQueue.isEmpty() ? 0 : pQueue.remove();
    }
}
