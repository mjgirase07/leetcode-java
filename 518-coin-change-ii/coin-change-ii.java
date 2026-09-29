class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }

        // return calc(n-1,amount,coins,dp);

        // //Tabulation
        // for(int amt=0; amt<=amount; amt++){
        //     if(amt%coins[0]==0) dp[0][amt] = 1;
        // }

        // for(int ind=1; ind<n; ind++){
        //     for(int amt=0; amt<=amount; amt++){
        //         int notTake = dp[ind-1][amt];
        //         int take = 0;
        //         if(coins[ind]<=amt) take = dp[ind][amt-coins[ind]];
        //         dp[ind][amt] = take+notTake;
        //     }
        // }

        // return dp[n-1][amount];

        //space optimization

        int[] prev = new int[amount+1];
        for(int amt=0; amt<=amount; amt++){
            if(amt%coins[0]==0) prev[amt] = 1;
        }

        for(int ind=1; ind<n; ind++){
            int[] curr = new int[amount+1];
            for(int amt=0; amt<=amount; amt++){
                int notTake = prev[amt];
                int take = 0;
                if(coins[ind]<=amt) take = curr[amt-coins[ind]];
                curr[amt] = take+notTake;
            }
            prev = curr;
        }
        return prev[amount];
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