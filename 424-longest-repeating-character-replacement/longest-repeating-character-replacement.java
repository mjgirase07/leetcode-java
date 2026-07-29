class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0,l=0,r=0,n=s.length(),maxFreq=0;
        int[] alpha = new int[26];

        while(r<n){
            alpha[s.charAt(r)-'A']++;

            maxFreq = Math.max(maxFreq, alpha[s.charAt(r)-'A']);

            if((r-l+1)-maxFreq>k){
                alpha[s.charAt(l)-'A']--;
                l++;
            }

            if((r-l+1)-maxFreq<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}