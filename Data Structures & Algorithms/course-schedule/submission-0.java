class Solution {
    public boolean detectCycle(int u, int n, List<List<Integer>> graph, boolean[] discovered, boolean[] visited) {
        discovered[u] = true;
        boolean isCyclic = false;
        for (int i=0; i<graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if (discovered[v]) return true;
            else {
                isCyclic = detectCycle(v, n, graph, discovered, visited);
            }
            if (isCyclic) break;
        }
        discovered[u] = false;
        visited[u] = true;
        return isCyclic;
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
        boolean[] discovered = new boolean[n];
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                if (detectCycle(i, n, graph, discovered, visited)) return false;
            }
        }

        return true;
    }
}
