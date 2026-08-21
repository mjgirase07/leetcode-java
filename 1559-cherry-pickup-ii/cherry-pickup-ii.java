class Solution {
    public int cherryPickup(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int[][][] dp = new int[r][c][c];

        for(int j1=0; j1<c; j1++){
            for(int j2=0;j2<c; j2++){
                if(j1==j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
            }
        }


        for(int i=r-2; i>=0; i--){
            for(int j1=0; j1<c; j1++){
                for(int j2=0; j2<c; j2++){

                    int maxi = -(int)1e8;
                    
                    for(int dj1 = -1; dj1<=1; dj1++){
                        for(int dj2 = -1; dj2<=1; dj2++){
                            
                            int value = 0;
                            if(j1==j2) value = grid[i][j1];
                            else value = grid[i][j1]+grid[i][j2];

                            if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c)
                                value+=dp[i+1][j1+dj1][j2+dj2];
                            else value = -(int) 1e8;
                            maxi = Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][c-1];

        // for(int[][] arr:dp){
        //     for(int[] arr2:arr){
        //         Arrays.fill(arr2,-1);
        //     }
        // }

        // return func(0,0,grid[0].length-1,grid.length,grid[0].length,grid,dp);
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