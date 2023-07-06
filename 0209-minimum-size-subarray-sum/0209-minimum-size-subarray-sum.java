class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] cumSum = new int[nums.length];
        cumSum[0] = nums[0];
        int min = 100001;
        for(int i = 1; i < cumSum.length; i++){
            cumSum[i] = cumSum[i-1] + nums[i];
        }
        for(int i = 0; i < cumSum.length; i++){
            if(cumSum[i] >= target){
                min = Math.min(min, i-largestSatisfiedIdx(cumSum, target, 0, i, i));
            }
        }
        return (min == 100001) ? 0 : min;
    }
    public int largestSatisfiedIdx(int[] cumSum, int target, int startIdx, int lastIdx, int q){
        if(startIdx == lastIdx){
            if(cumSum[q] - cumSum[startIdx] >= target){
                return startIdx;
            }
            else{
                return startIdx-1;
            }
        }
        int mid = (startIdx + lastIdx)/2;
        if(cumSum[q] - cumSum[mid] >= target){
            return largestSatisfiedIdx(cumSum, target, mid+1, lastIdx, q);
        }
        else{
            return largestSatisfiedIdx(cumSum, target, startIdx, mid, q);
        }
    }
}