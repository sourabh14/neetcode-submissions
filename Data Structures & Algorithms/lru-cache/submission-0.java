class Pair {
    int val, index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class LRUCache {
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> valIndx;
    private PriorityQueue<Pair> priorityQueue;
    private int currIndex;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        valIndx = new HashMap<>();
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.index));
        currIndex = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            valIndx.put(key, currIndex);
            priorityQueue.add(new Pair(key, currIndex));
            currIndex++;
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if ((!map.containsKey(key)) && (map.size() == capacity)) {
            // evict
            // remove stale entries
            while (valIndx.get(priorityQueue.element().val) != priorityQueue.element().index) priorityQueue.remove();

            Pair lru = priorityQueue.remove();
            valIndx.remove(lru.val);
            map.remove(lru.val);
        }
        valIndx.put(key, currIndex);
        priorityQueue.add(new Pair(key, currIndex));
        currIndex++;
        map.put(key, value);
    }
}
