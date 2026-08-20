class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        for(int i=0; i<triangle.get(n-1).size(); i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j)+dp[i+1][j];
                int diag = triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j] = Math.min(down,diag);
                
            }
        }

        return dp[0][0];
        //return func(0,0,triangle,dp);
    }
    int func(int i, int j, List<List<Integer>> t, int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==t.size()-1) return t.get(i).get(j);

        int down = t.get(i).get(j)+func(i+1,j,t,dp);
        int diag = t.get(i).get(j)+func(i+1,j+1,t,dp);

        return dp[i][j] = Math.min(down,diag);
    }
}