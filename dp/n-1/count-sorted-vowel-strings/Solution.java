class Solution {
    // Can be also done with permutation combination in O(1)

    // Now we have n characters, we are going to insert 4 l inside.
    // We can add in the front, in the middle and in the end.
    // How many ways do we have?
    // For the 1st l, we have n+1 position to insert.
    // For the 2nd l, we have n+2 position to insert.
    // For the 3rd l, we have n+3 position to insert.
    // For the 4th l, we have n+4 position to insert.
    // Also 4 l are the same,
    // there are (n + 1) * (n + 2) * (n + 3) * (n + 4) / 4! ways.

    // The character before the 1st l, we set to a.
    // The character before the 2nd l, we set to e.
    // The character before the 3rd l, we set to i.
    // The character before the 4th l, we set to o.
    // The character before the 5th l, we set to u.

    // We get the one result for the oringinal problem.

    public int countVowelStrings(int n) {
        // dp[i][j] count of string of length i which ends in jth alphabet of
        // {a,e,i,o,u}
        // ans for such string is summation of dp[i][j] for j E [0,4]
        // dp[i][j] = dp[i-1][j] + [1,5] depending upon j
        // eg ....a + (a,e,i,o,u)
        // ......e + (e,i,o,u)
        int[][] dp = new int[1][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[0][j] += dp[0][j - 1];
                // a=1 a=1 a=1
                // e=1 e=2 1 + 2
                // i=1 i=3 1 + 2 + 3
                // o=1 o=4
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++)
            ans += dp[0][i];
        return ans;
    }
}