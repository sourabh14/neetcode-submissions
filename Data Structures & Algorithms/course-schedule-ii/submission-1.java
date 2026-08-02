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
    
    public List<Integer> findOrderInternal(int u, List<List<Integer>> graph, boolean[] discovered, boolean[] visited, List<Integer> list) {
        discovered[u] = true;
        for (int v: graph.get(u)) {
            if (!discovered[v]) findOrderInternal(v, graph, discovered, visited, list);
        }
        visited[u] = true;
        list.add(u);
        return list;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) return new int[0];
        
        int n = numCourses;
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) graph.add(new ArrayList<>());
        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        boolean[] discovered = new boolean[n];
        boolean[] visited = new boolean[n];
        
        int indx = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                List<Integer> list = findOrderInternal(i, graph, discovered, visited, new ArrayList<>());
                for (int k: list) {
                    ans[indx] = k;
                    indx++;
                }
            }
        }

        return ans;
    }
}
