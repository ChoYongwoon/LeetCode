class Solution {
    public int longestPalindromeSubseq(String s) { // use dp and dfs
        int[][] dp = new int[s.length()][s.length()];  // dp[i][j] means longest palindromic subsequence from i index to j index
        for(int i = 0; i < dp.length; i++){ // dp [i][i] needts to be 1
            dp[i][i] = 1;
        }
        int res = search(dp, 0, s.length()-1, s);  // the result is dp[0][s.length()-1]
        return res;
    }
    
    public int search(int[][] dp, int i, int j, String s){ // calculate dp[i][j]
        if(i > j){return 0;}                               // illegal -> return 0
        if(dp[i][j] != 0){return dp[i][j];}                // if dp[i][j] is calculated before, return dp[i][j]

        int tmp = 0;
        tmp = Math.max(search(dp, i+1,j,s), search(dp,i,j-1,s));  // dp[i][j] = Max(dp[i+1][j], dp[i][j-1], dp[i+1][j-1] + 2(if s[i]==s[j]))
        if(s.charAt(i) == s.charAt(j)){
            tmp = Math.max(tmp, search(dp, i+1, j-1, s)+2);
        }
        dp[i][j] = tmp; // save the value
        return dp[i][j];
    }
}