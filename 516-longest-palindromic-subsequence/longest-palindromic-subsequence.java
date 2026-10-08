class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return lcs(0,n-1,s,dp);
    }

    int lcs(int i, int j, String s, int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)) dp[i][j] = 2 + lcs(i+1,j-1,s,dp);
        else dp[i][j] = Math.max(lcs(i+1,j,s,dp),lcs(i,j-1,s,dp));

        return dp[i][j];
    }
}