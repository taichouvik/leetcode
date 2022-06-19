class Solution {
    public int climbStairs(int n) {
        //dp[i] way to reach i
        int[] dp = new int[2];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i%2]=dp[0]+dp[1];
        }
        return dp[(n-1) %2];
    }
}