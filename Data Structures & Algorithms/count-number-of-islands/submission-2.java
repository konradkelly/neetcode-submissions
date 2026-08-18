class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    if (!visited.contains(row + ", " + col)) {
                    dfs(grid, row, col, visited);
                    count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, Set<String> visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;

        String key = row + ", " + col;
        if (visited.contains(key)) return;
        if (grid[row][col] == '0') return;

        visited.add(key);

        int[][] directions = {
            {-1,  0}, // UP
            { 1,  0}, // DOWN
            { 0, -1}, // LEFT
            { 0,  1}, // RIGHT
        };

        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited);
        }
    }
}