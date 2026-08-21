class Solution {
    public int cherryPickup(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int[][][] dp = new int[r][c][c];

        for(int[][] arr:dp){
            for(int[] arr2:arr){
                Arrays.fill(arr2,-1);
            }
        }

        return func(0,0,grid[0].length-1,grid.length,grid[0].length,grid,dp);
    }

    int func(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2>=c) return -(int)1e8;
        if(i==r-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = 0;
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                int value = 0;
                if(j1==j2) value = grid[i][j1];
                else value = grid[i][j1]+grid[i][j2];
                value+=func(i+1,j1+dj1,j2+dj2,r,c,grid,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}