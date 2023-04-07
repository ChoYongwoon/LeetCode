class Solution {
    public int numEnclaves(int[][] grid) { // checking the number of enclosed land cells.
        for(int i = 0; i < grid.length; i++){ // execute dfs toward the cells in upper and lower boundary.
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length-1);
        }
        for(int j = 0; j < grid[0].length; j++){ // execute dfs toward the cells in left and right boundary.
            dfs(grid, 0, j);
            dfs(grid, grid.length-1, j);
        }
        
        int res = 0;
        for(int i = 0; i < grid.length; i++){ // count the 1 cells in grid.
            for(int j = 0; j < grid[0].length; j++){ 
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] grid, int i, int j){ // convert the land(1) connected to [i,j] to 0.
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){return;}
        if(grid[i][j] == 0){return;}
        
        grid[i][j] = 0;
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
    }
}