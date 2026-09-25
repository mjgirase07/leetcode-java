class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        
        // int ans = calc(n-1,amount,coins,dp);
        // return ans >= (int)1e9 ? -1 : ans;

        for(int amt=0; amt<=amount; amt++){
            if(amt%coins[0]==0) dp[0][amt] = amt/coins[0];
            else dp[0][amt] = (int)1e9;
        }

        for(int i=1; i<n; i++){
            for(int amt=0; amt<=amount; amt++){
                int notTake = dp[i-1][amt];
                int take = (int)1e9;
                if(coins[i]<=amt) take = 1 + dp[i][amt-coins[i]];
                dp[i][amt] = Math.min(take,notTake);
            }
        }
         int ans = dp[n-1][amount];
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