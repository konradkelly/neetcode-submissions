class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
        Loop through every row

        Loop through every column

        If the cell is land (1):

        That cell is your starting point

        Run DFS from there

        DFS returns the area of that island

        Update your max area

        */
        Set<String> visited = new HashSet<>();
        int maxArea = 0;        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                   int area = dfs(grid, row, col, visited);
    
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
    }
    return maxArea;        
    }
    
    private static int dfs(int[][] grid, int row, int col, Set<String> visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0) return 0;
        
        String key = row + ", " + col;
        if (visited.contains(key)) return 0;
        
        visited.add(key);

        int area = 1;

        area += dfs(grid, row - 1, col, visited);    
        area += dfs(grid, row + 1, col, visited);
        area += dfs(grid, row, col - 1, visited);
        area += dfs(grid, row, col + 1, visited);   

        return area;
        }
    }
