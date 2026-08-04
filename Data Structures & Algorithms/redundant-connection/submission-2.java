class DisjointSet {
    int[] parent;

    public DisjointSet(int n) {
        parent = new int[n+1]; // 1 based index
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int u) {
        while (parent[u] != parent[parent[u]]) parent[u] = parent[parent[u]];
        
        return parent[u];
    }

    public void mergeSet(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        parent[rootU] = rootV;
    }

    public boolean connected(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        return rootU == rootV;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet disjointSet = new DisjointSet(n);

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if (disjointSet.connected(u, v)) return edge;
            disjointSet.mergeSet(u, v);
        }

        return new int[2];
    }
}
