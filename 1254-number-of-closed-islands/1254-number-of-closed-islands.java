class Solution {
    public int closedIsland(int[][] grid) { // checking closed land for all cell with value 0.
        int res = 0;
        
        for(int i = 0; i < grid.length; i++){ 
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==0){
                    res += dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j){ // dfs for check closed or not and renew the value in grid.
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){ // out of range -> 0(means open)
            return 0;
        }
        if(grid[i][j] == 1){return 1;} // water or already visited land return 0.
        int res = 0; 
        grid[i][j] = 1; // For checking visited or not
        res = dfs(grid,i-1,j)*dfs(grid,i,j-1)*dfs(grid,i+1,j)*dfs(grid,i,j+1); // Every boundary is closed -> 1(closed) or 0(open)
        return res;
    }
}