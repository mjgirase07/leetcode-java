class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i=0; i<ans.length; i++){
            ans[i] = numsOfBits(i);
        }
        return ans;
    }

    int numsOfBits(int n){
        int cnt = 0;
        while(n!=0){
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
}