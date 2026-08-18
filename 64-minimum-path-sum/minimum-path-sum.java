class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n=grid[0].length;

        int[] prev = new int[n];

        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j] = grid[i][j];
                    continue;
                }

                int up = (i>0)?prev[j]+grid[i][j]:(int)1e9;
                int left = (j>0)?temp[j-1]+grid[i][j]:(int)1e9;

                temp[j] = Math.min(up,left);
            }
            prev = temp;
        }

        return prev[n-1];

        // int[][] dp = new int[m][n];
        // for(int[] arr: dp){
        //     Arrays.fill(arr,-1);
        // }

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         if(i==0 && j==0){
        //             dp[i][j] = grid[i][j];
        //             continue;
        //         }

        //         int up = (i>0)?dp[i-1][j]+grid[i][j]:(int)1e9;
        //         int down = (j>0)?dp[i][j-1]+grid[i][j]:(int)1e9;

        //         dp[i][j] = Math.min(up,down);
        //     }
        // }

        // return dp[m-1][n-1];
        //return func(m-1,n-1,dp,grid);
        
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