class Solution {
    public boolean detectCycle(int u, int parent, List<List<Integer>> graph, boolean[] discovered, boolean[] visited) {
        discovered[u] = true;
        for (int v: graph.get(u)) {
            if (v != parent) {
                if (discovered[v]) return true;
                if (detectCycle(v, u, graph, discovered, visited)) return true;
            }
        }
        visited[u] = true;
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] discovered = new boolean[n];
        boolean[] visited = new boolean[n];

        if (detectCycle(0, -1, graph, discovered, visited)) return false;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
