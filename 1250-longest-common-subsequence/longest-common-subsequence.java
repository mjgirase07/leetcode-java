class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return lcs(n-1,m-1,text1,text2,dp);
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