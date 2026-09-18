class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childInd = 0;
        int cookieInd = 0;
    
        while(childInd<g.length && cookieInd<s.length){
            if(g[childInd]<=s[cookieInd]){
                childInd++;
            }
            cookieInd++;
        }

        return childInd;

        // int[] dp = new int[s.length+1];
        // // for(Integer[] arr:dp){
        // //     Arrays.fill(arr,-1);
        // // }
        // for(int ch=g.length-1; ch>=0; ch--){
        //     int[] curr = new int[s.length+1];
        //     for(int co = s.length-1; co>=0; co--){
        //         int skip = dp[co+1];
        //         int take = 0;
        //         if(g[ch]<=s[co]) take = 1 + dp[co+1];
        //         curr[co] = Math.max(take,skip);
        //     }
        //     dp = curr;
        // }
       
        // //return helper(0,0,g,s,dp);
        // return dp[0];
    }

    int helper(int childInd, int cookieInd, int[] child, int[] cookie, Integer[][] dp){
        if(childInd >= child.length || cookieInd >= cookie.length) return 0;
        if(dp[childInd][cookieInd]!=-1) return dp[childInd][cookieInd];

        int result = 0;

        if(child[childInd] <= cookie[cookieInd]){
            result = Math.max(result, 1 + helper(childInd+1, cookieInd+1, child, cookie,dp));
        }

        result = Math.max(result, helper(childInd, cookieInd+1, child, cookie,dp));

        return dp[childInd][cookieInd] = result;
    }
}