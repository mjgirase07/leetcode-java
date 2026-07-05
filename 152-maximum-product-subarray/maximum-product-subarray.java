class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre=1,suffix=1;

        for(int i=0; i<nums.length; i++){
           if(pre==0) pre=1;
           if(suffix==0) suffix=1;
           pre *= nums[i];
           suffix *= nums[nums.length-1-i];
           max = Math.max(max,Math.max(pre,suffix));
        }

        return max;
    }
}