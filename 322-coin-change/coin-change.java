class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        
        int ans = calc(n-1,amount,coins,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }

    int calc(int ind, int amt, int[] coins, int[][] dp){
        if(ind == 0){
            if(amt%coins[0]==0) return amt/coins[0];
            else return (int)1e9;
        }

        if(dp[ind][amt] != -1) return dp[ind][amt];

        int notTake = calc(ind-1, amt,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amt) take = 1+calc(ind,amt-coins[ind],coins,dp);

        return dp[ind][amt] = Math.min(take,notTake);
    }
}