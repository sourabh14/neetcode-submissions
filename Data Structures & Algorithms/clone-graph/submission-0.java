/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraphInternal(Node node, Map<Integer, Node> nodeMap) {
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        
        Node newNode = new Node(node.val);
        nodeMap.put(newNode.val, newNode);
        
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(cloneGraphInternal(neighbor, nodeMap));
        }
        
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        Map<Integer, Node> nodeMap = new HashMap<>();
        return cloneGraphInternal(node, nodeMap);
    }
}