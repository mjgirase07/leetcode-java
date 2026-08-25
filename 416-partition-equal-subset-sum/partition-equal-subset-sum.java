class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        for(int n:nums){
            totalSum += n;
        }

        if (totalSum%2!=0) return false;
        int[][] dp = new int[nums.length][(totalSum/2) + 1];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return func(nums.length-1,totalSum/2,nums, dp);
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