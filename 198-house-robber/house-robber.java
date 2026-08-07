class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        
        // fun(nums.length-1,nums,dp);

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        dp[0]=nums[0];
        int neg = 0;

        int pick = Integer.MIN_VALUE;
        int notPick = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++){
            
            if(i-2<neg){
                pick = nums[i];
            }
            
            else{
                pick = nums[i]+dp[i-2];
            }
                notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length-1];
    }

    static int fun(int ind,int[] nums, int[] dp){
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = Math.max(fun(ind-2,nums,dp)+nums[ind],fun(ind-1,nums,dp));

    }
}