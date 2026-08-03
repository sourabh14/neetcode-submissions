class Solution {
    public void dfs(int u, List<List<Integer>> graph, boolean[] discovered, boolean[] visited) {
        discovered[u] = true;
        for (int v: graph.get(u)) {
            if (!discovered[v]) dfs(v, graph, discovered, visited);
        }
        visited[u] = true;
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] discovered = new boolean[n];
        boolean[] visited = new boolean[n];

        int connectedComponents = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(i, graph, discovered, visited);
            }
        }
        return connectedComponents;
    }
}
