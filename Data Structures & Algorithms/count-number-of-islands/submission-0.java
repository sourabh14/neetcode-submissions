class Solution {
    public boolean isValid(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return (i>=0 && j>=0 && i<m && j<n);
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] discovered) {
        discovered[i][j] = true;

        if (isValid(i+1, j, grid) && grid[i+1][j] == '1' && !discovered[i+1][j]) {
            dfs(i+1, j, grid, discovered);
        }

        if (isValid(i-1, j, grid) && grid[i-1][j] == '1' && !discovered[i-1][j]) {
            dfs(i-1, j, grid, discovered);
        }

        if (isValid(i, j+1, grid) && grid[i][j+1] == '1' && !discovered[i][j+1]) {
            dfs(i, j+1, grid, discovered);
        }

        if (isValid(i, j-1, grid) && grid[i][j-1] == '1' && !discovered[i][j-1]) {
            dfs(i, j-1, grid, discovered);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] discovered = new boolean[m][n];
        int ans = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !discovered[i][j]) {
                    ans++;
                    dfs(i, j, grid, discovered);
                }
            }
        }

        return ans;
    }
}
