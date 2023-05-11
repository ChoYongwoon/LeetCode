class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // initialize dp matrix
        int[][] dp = new int[nums1.length][nums2.length]; 
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                dp[i][j] = -1;
            }
        }
        return recurSolve(0, 0, nums1, nums2, dp);
    }
    
    private int recurSolve(int i, int j, int[] nums1, int[] nums2, int[][] dp){ // method to solve recursively
        if(i >= nums1.length){return 0;} // out of range -> return 0
        if(j >= nums2.length){return 0;} // out of range -> return 0
        if(dp[i][j] != -1){return dp[i][j];} // if there is precalculated value, return that one
        
        int next_j = j;                  // variable to indicate the index of nums2 contains the value same with nums1[i]
        while(next_j < nums2.length && nums1[i] != nums2[next_j]){next_j ++;}   // find the index
        
        if(next_j == nums2.length){      // if it is not matched
            dp[i][j] = recurSolve(i+1, j, nums1, nums2, dp);   // skip i, and solve for next i(i+1)
            return dp[i][j];
        }else{                           // if it is match
            // return the bigger set (one contains nums1[i], anothoer one not contains nums1[i])
            dp[i][j] = Math.max(1 + recurSolve(i+1, next_j+1, nums1, nums2, dp), recurSolve(i+1, j, nums1, nums2, dp));     
            return dp[i][j];
        }
        
    }
}