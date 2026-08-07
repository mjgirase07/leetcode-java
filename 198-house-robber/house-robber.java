class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        fun(nums.length-1,nums,dp);
        return dp[nums.length-1];
    }

    static int fun(int ind,int[] nums, int[] dp){
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = Math.max(fun(ind-2,nums,dp)+nums[ind],fun(ind-1,nums,dp));

    }
}