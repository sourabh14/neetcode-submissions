class Solution {
    public boolean detectCycle(int u, List<List<Integer>> graph, boolean[] recstack, boolean[] visited) {
        recstack[u] = true;
        for (int v: graph.get(u)) {
            if (recstack[v]) return true;
            if (!visited[v] && detectCycle(v, graph, recstack, visited)) return true;
        }
        recstack[u] = false;
        visited[u] = true;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());
        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        boolean[] recstack = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                if (detectCycle(i, graph, recstack, visited)) return false;
            }
        }

        return true;
    }
}
