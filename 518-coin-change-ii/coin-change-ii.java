class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return calc(n-1,amount,coins,dp);
        
    }

    int calc(int ind, int amount, int[] coins, int[][] dp){
        if(ind==0){
            return (amount%coins[0]==0) ? 1:0;
            
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notTake = calc(ind-1,amount,coins,dp);
        int take = 0;
        if(amount>=coins[ind]) take = calc(ind,amount-coins[ind],coins,dp);
        return dp[ind][amount] = take+notTake;
    }
}