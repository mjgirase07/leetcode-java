class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(Integer num:nums){
            set.add(num);
        }

        return set.size()==nums.length? false:true;
    }
}