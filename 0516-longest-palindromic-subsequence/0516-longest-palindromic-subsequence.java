class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            dp[i][i] = 1;
        }
        int res = search(dp, 0, s.length()-1, s);
        return res;
    }
    public int search(int[][] dp, int i, int j, String s){
        if(i > j){return 0;}
        if(dp[i][j] != 0){return dp[i][j];}

        int tmp = 0;
        tmp = Math.max(search(dp, i+1,j,s), search(dp,i,j-1,s));
        if(s.charAt(i) == s.charAt(j)){
            tmp = Math.max(tmp, search(dp, i+1, j-1, s)+2);
        }
        dp[i][j] = tmp;
        return dp[i][j];
    }
}