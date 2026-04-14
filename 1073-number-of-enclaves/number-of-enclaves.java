class Solution {
    private void dfs(int row, int col, int[][] grid, int[][] vis, int[] delrow, int[] delcol){
        vis[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis = new int[m][n];

        int[] delrow = {0,0,1,-1};
        int[] delcol = {1,-1,0,0};

        // //traverse the 1st and last row
        // for(int i=0; i<n; i++){
        //     if(vis[0][i]==0 && grid[0][i]==1){
        //         dfs(0,i,grid,vis,delrow,delcol);
        //     }
        //     if(vis[m-1][i]==0 && grid[m-1][i]==1){
        //         dfs(m-1,i,grid,vis,delrow,delcol);
        //     }
        // }

        // //traverse the 1st and last col
        // for(int i=0; i<m; i++){
        //     if(vis[i][0]==0 && grid[i][0]==1){
        //         dfs(i,0,grid,vis,delrow,delcol);
        //     }
        //     if(vis[i][n-1]==0 && grid[i][n-1]==1){
        //         dfs(i,m-1,grid,vis,delrow,delcol);
        //     }
        // }

        //traverse 1st and last row
        for(int i=0; i<n; i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(0, i, grid, vis, delrow, delcol);
            }
            if(vis[m-1][i]==0 && grid[m-1][i]==1){
                dfs(m-1, i, grid, vis, delrow, delcol);
            }
        }

        //traverse 1st col and last col
        for(int i=0; i<m; i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i, 0, grid, vis, delrow, delcol);
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(i, n-1, grid, vis, delrow, delcol);
            }
        }
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}