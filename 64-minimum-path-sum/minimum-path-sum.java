class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n=grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return func(m-1,n-1,dp,grid);
        
    }
    int func(int i, int j, int[][] dp, int[][] grid){
        if(i<0 || j<0)  return (int) 1e9;
        if((i==0) && j==0) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        int up = func(i-1,j,dp,grid)+grid[i][j];
        int left = func(i,j-1,dp,grid)+grid[i][j];

        return dp[i][j] = Math.min(up,left);
    }
}