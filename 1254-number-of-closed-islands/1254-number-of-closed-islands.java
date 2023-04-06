class Solution {
    public int closedIsland(int[][] grid) {
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
    
    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] == 1){return 1;}
        int res = 0;
        grid[i][j] = 1;
        res = dfs(grid,i-1,j)*dfs(grid,i,j-1)*dfs(grid,i+1,j)*dfs(grid,i,j+1);
        return res;
    }
}