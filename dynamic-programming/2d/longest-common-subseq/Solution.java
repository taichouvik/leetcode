class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // text2
        // text1
        int[][] dp = new int[1003][1003];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //if prev suffixs ends at same char then prev soln & cur is +1 of that val
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1; //cool trick to deal with i-1 th bound checks
                else
                    dp[i + 1][j + 1] = Integer.max(dp[i][j + 1], dp[i + 1][j]);
            }

        }
        return dp[m][n];
    }
    public static void main(String[] args) {
       System.out.println(longestCommonSubsequence("text1", "text2"));
    }
}