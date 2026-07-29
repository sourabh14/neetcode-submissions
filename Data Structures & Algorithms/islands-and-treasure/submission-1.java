class Node {
    int i, j;
    int dist;

    public Node(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}

class Solution {
    public boolean isValid(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return (i>=0 && j>=0 && i<m && j<n);
    }

    public void bfs(int u, int v, int[][] grid, boolean[][] discovered) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(u, v, 0));

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int i = node.i;
            int j = node.j;
            grid[i][j] = Math.min(grid[i][j], node.dist);
            discovered[i][j] = true;

            if (isValid(i+1, j, grid) && !discovered[i+1][j] && grid[i+1][j] != -1) {
                queue.add(new Node(i+1, j, node.dist+1));
            }

            if (isValid(i-1, j, grid) && !discovered[i-1][j] && grid[i-1][j] != -1) {
                queue.add(new Node(i-1, j, node.dist+1));
            }

            if (isValid(i, j+1, grid) && !discovered[i][j+1] && grid[i][j+1] != -1) {
                queue.add(new Node(i, j+1, node.dist+1));
            }

            if (isValid(i, j-1, grid) && !discovered[i][j-1] && grid[i][j-1] != -1) {
                queue.add(new Node(i, j-1, node.dist+1));
            }
        }

    }

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] discovered = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    for (int k=0; k<m; k++) {
                        Arrays.fill(discovered[k], false);
                    }
                    bfs(i, j, grid,  discovered);
                }
            }
        }
    }
}
