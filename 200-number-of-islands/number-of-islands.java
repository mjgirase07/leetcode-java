class Solution {

    private void dfs(int row, int col, char[][] grid, int[][] vis, int[] delrow, int[] delcol){
        vis[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] delrow = {0,0,1,-1};
        int[] delcol = {-1,1,0,0};
        int cnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,grid,vis,delrow,delcol);
                }
            }
        }
        return cnt;
    }
}