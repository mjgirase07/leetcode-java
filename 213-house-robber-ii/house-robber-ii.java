class Solution {
    public int rob(int[] nums) {
        // if(nums.length==1) return nums[0];
        // int[] dp1 = new int[nums.length-1];
        // int[] dp2 = new int[nums.length];
        // Arrays.fill(dp1,-1);
        // Arrays.fill(dp2,-1);
        // rob1(nums.length-2,nums,dp1);
        // rob2(nums.length-1,nums,dp2);
        // return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i!=0) arr1.add(nums[i]);
            if(i!=nums.length-1) arr2.add(nums[i]);
        }

        return Math.max(solve(arr1),solve(arr2));
    }

    int rob1(int ind, int[] nums, int[] dp){
        if(ind<0) return 0;
        if (ind == 0) return nums[0];
        if(dp[ind]!=-1) return dp[ind];
        return dp[ind] = Math.max(rob1(ind-2,nums,dp)+nums[ind], rob1(ind-1,nums,dp));
    }

    int rob2(int ind, int[] nums, int[] dp){
        if(ind<1) return 0;
        if (ind == 1) return nums[1];
        if(dp[ind]!=-1) return dp[ind];
        return dp[ind] = Math.max(rob2(ind-2,nums,dp)+nums[ind], rob2(ind-1,nums,dp));
    }

    int solve(List<Integer> arr){
        int n = arr.size();
        if(n==1) return arr.get(0);

        int prev = arr.get(0);
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int pick=arr.get(i);
            if(i>1) pick += prev2;
            int notPick = prev;

            int curi = Math.max(pick, notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}