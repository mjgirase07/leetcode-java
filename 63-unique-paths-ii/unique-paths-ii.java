class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int[][] dp = new int[og.length][og[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return func(og.length-1,og[0].length-1,dp,og);
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