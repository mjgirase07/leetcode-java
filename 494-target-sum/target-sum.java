class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int a:nums){
            totalSum += a;
        }

        int newTarget = totalSum-target;
        if(newTarget<0 || newTarget%2!=0){
            return 0;
        }

        int[][] dp = new int[n][newTarget+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return calc(n-1,newTarget/2,nums,dp);
    }
    int calc(int ind, int target, int[] arr, int[][] dp){
        if(ind == 0){
            if(target==0 && arr[0]==0) return 2;
            else if(target==0 || target==arr[0]) return 1;
            else return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = calc(ind-1, target,arr,dp);
        int take = 0;
        if(arr[ind]<=target) take = calc(ind-1, target-arr[ind],arr,dp);
        return dp[ind][target] = take+notTake;
    }
}