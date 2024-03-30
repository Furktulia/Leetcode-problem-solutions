class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> numOfOccur = new HashMap<>();
        int lFar = 0, lNear = 0, numOfSubarr = 0;

        for(int r = 0; r < nums.length; ++r){
            numOfOccur.put(nums[r], numOfOccur.getOrDefault(nums[r], 0) + 1);

            while(numOfOccur.size() > k){
                if(numOfOccur.get(nums[lNear]).equals(1)){
                    numOfOccur.remove(nums[lNear++]);
                } else{
                    numOfOccur.put(nums[lNear], numOfOccur.get(nums[lNear++]) - 1);
                }

                lFar = lNear;
            }

            while(numOfOccur.get(nums[lNear]) > 1){
                numOfOccur.put(nums[lNear], numOfOccur.get(nums[lNear++]) - 1);
            }
            
            if(numOfOccur.size() == k){
                numOfSubarr +=  lNear - lFar + 1;
            }
        }
        return numOfSubarr;
    }
}