class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        // int[][] dp = new int[og.length][og[0].length];
        
        // for(int i=0; i<og.length; i++){
        //     for(int j=0; j<og[0].length; j++){
        //         dp[i][j]=-1;
        //     }
        // }

        // if(og[0][0] == 1) return 0;
        int m=og.length;
        int n=og[0].length;

        int[] prev = new int[n];

        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(og[i][j]==1){
                     temp[j] = 0;
                     continue;
                } 
                if(i==0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                int up = (i>0)? prev[j]:0;
                int left = (j>0)? temp[j-1]:0;

                temp[j] = up+left;
            }
            prev = temp;
        }

        return prev[n-1];
        
        // for(int i=0; i<og.length; i++){
        //     for(int j=0; j<og[0].length; j++){
        //         if(og[i][j]==1){
        //             dp[i][j] = 0;
        //             continue;
        //             } 
        //         else {
        //             if(i==0 && j==0){
        //                 dp[i][j] = 1;
        //                 continue;
        //             }

        //             int up = (i>0)?dp[i-1][j]:0;
        //             int left = (j>0)?dp[i][j-1]:0;

        //             dp[i][j] = up+left;
        //         }
        //     }
        // }
        // return dp[og.length-1][og[0].length-1];
        //return func(og.length-1,og[0].length-1,dp,og);
    }

    int func(int i, int j, int[][] dp, int[][] og){
        if(i<0 || j<0) return 0;
        if(og[i][j] == 1) return 0;
        if(i==0 && j==0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int up = func(i-1,j,dp,og);
        int down  = func(i, j-1, dp, og);

        return dp[i][j] = up+down;
    }
}