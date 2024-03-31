class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0, indexBad = -1, indexMin = -1, indexMax = -1;

        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == minK) indexMin = i;
            if(nums[i] == maxK) indexMax = i;
            if(nums[i] > maxK || nums[i] < minK) indexBad = i;
            ans += Math.max(Math.min(indexMin, indexMax) - indexBad , (long) 0);
        }
        return ans;
    }
}