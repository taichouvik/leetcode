import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
class Solution {
    public static List<List<Integer>> generate(int numRows) {
        //pascaltraingle looks like this
        // 1
        // 1 1
        // 1 2 1
        // 1 3 3 1

        //dp[i][j] is the value of triangle at i,j
        int[][] dp = new int[31][31];
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            //#colums in each row is equal to row number
            for (int j = 0; j <= i; j++) {
                //if not an edge case then ans depends on upper and upper left grid
                if (i > 0 && j > 0)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                //first column is always 1
                if (j == 0)
                    dp[i][j] = 1;
                //last column in the diagonal is 1
                if (i == j)
                    dp[i][j] = 1;
                sub.add(dp[i][j]);
            }
            ans.add(sub);
        }
        return ans;

    }

    public static void main(String[] args) {
        generate(5).forEach(System.out::print);
    }
}