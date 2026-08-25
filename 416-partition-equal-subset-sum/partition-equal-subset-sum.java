class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        for(int n:nums){
            totalSum += n;
        }
        int target = totalSum/2;

        if (totalSum%2!=0) return false;
        //Memoization Solution
        //int[][] dp = new int[nums.length][(totalSum/2) + 1];

        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }

        //return func(nums.length-1,totalSum/2,nums, dp);

        // boolean[][] dp = new boolean[nums.length][target + 1];

      //Tabulation Solution
        // for(int i=0; i<dp.length; i++){
        //     dp[i][0] = true;
        // }

        // if(nums[0]<=target) dp[0][nums[0]] = true;

        // for(int i=1; i<nums.length; i++){
        //     for(int j=1; j<=target; j++){
        //         boolean notTaken = dp[i-1][j];
        //         boolean taken = false;
        //         if(nums[i]<=j){
        //             taken = dp[i-1][j-nums[i]];
        //         }
        //         dp[i][j] = taken || notTaken;
        //     }
        // }

        // return dp[nums.length-1][target];

        //Space Optimization solution

        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(nums[0]<=target) prev[nums[0]] = true;

        for(int i=1; i<nums.length; i++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int j=1; j<=target; j++){
                boolean notTaken = prev[j];
                boolean taken =  false;
                if(nums[i]<=j){
                    taken = prev[j-nums[i]];
                }
                curr[j] = taken || notTaken;
            }
            prev = curr;
        }
        return prev[target];
    }
    boolean func(int ind, int target, int[] nums, int[][] dp){
        if(target==0) return true;
        if(ind==0) return target==nums[0];
        if(dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean notTaken = func(ind-1,target,nums,dp);
        boolean taken = false;
        if(nums[ind]<=target)
            taken = func(ind-1,target-nums[ind],nums,dp);
        dp[ind][target] = (taken || notTaken)?1:0;
        return taken || notTaken;
    }
}