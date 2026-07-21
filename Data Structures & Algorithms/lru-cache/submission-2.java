class Node {
    int key, val;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        // dummy values
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void add(Node node) {
        // insert after head
        Node headNext = head.next;
        head.next = node;
        headNext.prev = node;
        node.next = headNext;
        node.prev = head;
    }

    public void remove(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    public Node getLru() {
        return tail.prev;
    }

    public void moveToFront(Node node) {
        remove(node);
        add(node);
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new DoublyLinkedList();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            // update recency
            queue.moveToFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            queue.moveToFront(node);
        } else {
            if (map.size() < capacity) {
                Node node = new Node(key, value);
                map.put(key, node);
                queue.add(node);
            } else {
                // evict
                Node lru = queue.getLru();
                map.remove(lru.key);
                queue.remove(lru);

                Node node = new Node(key, value);
                map.put(key, node);
                queue.add(node);
            }
        }
    }
}