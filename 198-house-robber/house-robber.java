class Solution {
    public int rob(int[] nums) {
       // int[] dp = new int[nums.length];
       // Arrays.fill(dp,-1);
        
        // fun(nums.length-1,nums,dp);

       // dp[0]=nums[0];
        
        int prev =nums[0], curr=0;
        int prev2 = 0;

        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1){
                pick = nums[i]+prev2;
            }
            
            int notPick = prev;

            curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    static int fun(int ind,int[] nums, int[] dp){
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = Math.max(fun(ind-2,nums,dp)+nums[ind],fun(ind-1,nums,dp));

    }
}