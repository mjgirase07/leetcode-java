class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0],i=0;

        while(i<prices.length){
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(prices[i]-minPrice, max);
            i++;
        }
        return max;
    }
}