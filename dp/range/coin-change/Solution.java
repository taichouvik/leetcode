import java.util.Arrays;

class Solution {
    public static int coinChange(int[] coins, int amount) {
        // (0)->k (Q)->k (P)->k
        int[] dp = new int[10004];
        int n = coins.length;
        Arrays.sort(coins, 0, n);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n && i - coins[j] > -1; j++) {
                dp[i] = Integer.min(dp[i], dp[i - coins[j]]);

            }
            if (dp[i] != Integer.MAX_VALUE)
                dp[i]++;
        }
        return dp[amount] + 1 < 0 ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    
    }
}