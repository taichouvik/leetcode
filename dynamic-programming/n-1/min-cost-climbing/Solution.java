class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i] is the min cost after paying
        int[] dp = new int[2];
        
        //base cases
        dp[0]  = cost[0];
        //starting with index1 will always be better than starting with 
        //index0 and then coming to index 1
        dp[1] = cost[1];
        int n = cost.length;
       
        for(int i=2;i<n;i++)
            dp[i%2]=Math.min(dp[0],dp[1]) + cost[i];
        
        //ans state lies outside the array, hence use the last 2 state inside
        //the array
        return Math.min(dp[0],dp[1]);
    }}