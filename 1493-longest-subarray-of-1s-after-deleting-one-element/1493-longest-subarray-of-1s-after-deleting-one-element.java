class Solution {
    public int longestSubarray(int[] nums) {
        int[] dp = new int[nums.length];
        List<Integer> idx = new ArrayList<>();
        dp[0] = nums[0] == 0 ? 0 : 1;
        for(int i = 1; i < dp.length; i++){
            if(nums[i] == 0){
                dp[i] = 0;
                if(dp[i-1] != 0){
                    idx.add(i-1);
                }
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }
        if(dp[dp.length-1] != 0){
            idx.add(dp.length-1);
        }

        int min = 100001;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] < min){
                min = dp[i];
            }
        }
        
        if(idx.size()==0){return 0;}
        else if(idx.size()==1){
            if(min == 0){
                return dp[idx.get(0)];
            }
            else{
                return dp[idx.get(0)]-1;
            }
        }
        else{
            int max = -1;
            for(int i = 0; i < idx.size()-1; i++){
                int tmp = 0;
                tmp = dp[idx.get(i)];
                if(dp[idx.get(i+1)] == (idx.get(i+1)- idx.get(i) - 1)){
                    tmp = dp[idx.get(i)] + dp[idx.get(i+1)];
                }
                max = Math.max(tmp, max);
            }
            max = Math.max(max, dp[idx.get(idx.size()-1)]);
            return max;
        }
    }
}