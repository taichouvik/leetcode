import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> getRow(int rowIndex) {
        int h = rowIndex;
        // dp[i-1][j] + dp[i-1][j-1]
        int[] dp = new int[35];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= h; i++) {
            int dpj1 = 1;
            // bad choice of direction, since 1 state only depends on
            // adjacent state so iterating j from high to low
            // would have worked and prevent code for temp;
            for (int j = 0; j <= i; j++) {

                if (j == 0 || i == j)
                    dp[j] = 1;

                else {
                    int tdpj1 = dp[j];
                    dp[j] = dp[j] + dpj1;
                    dpj1 = tdpj1;
                }
                if (i == h)
                    ans.add(dp[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
}