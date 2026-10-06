class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }

        // return lcs(n-1,m-1,text1,text2,dp);

        // for(int i=0; i<=n; i++) dp[i][0] = 0;
        // for(int i=0; i<=m; i++) dp[0][i] = 0;

        // for(int s1=1; s1<=n; s1++){
        //     for(int s2=1; s2<=m; s2++){
        //         if(text1.charAt(s1-1) == text2.charAt(s2-1)) {
        //             dp[s1][s2] = 1 + dp[s1-1][s2-1];
        //         }
        //         else dp[s1][s2] = Math.max(dp[s1-1][s2],dp[s1][s2-1]);
        //     }
        // }
        // return dp[n][m];

        //Space Optimization
        int[] prev = new int[m+1];
        
        for(int s1=1; s1<=n; s1++){
            int[] curr = new int[m+1];
            for(int s2=1; s2<=m; s2++){
                if(text1.charAt(s1-1) == text2.charAt(s2-1)) curr[s2] = 1 + prev[s2-1];
                else curr[s2] = Math.max(prev[s2],curr[s2-1]);
            }
            prev = curr;
        }
        return prev[m];
    }

    int lcs(int s1, int s2, String text1, String text2,int[][] dp){
        if(s1<0 || s2<0){
            return 0;
        }
        if(dp[s1][s2] != -1) return dp[s1][s2];

        if(text1.charAt(s1) == text2.charAt(s2)) {
            return 1 + lcs(s1-1,s2-1,text1,text2,dp);
        }
        return dp[s1][s2] = Math.max(lcs(s1-1,s2,text1,text2,dp),lcs(s1,s2-1,text1,text2,dp));
    }
}