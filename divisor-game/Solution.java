public class Solution {
    // return true if alice win
    public static boolean divisorGame(int n) {
        Boolean[] dp = new Boolean[1000 + 1];

        // dp[i] represents whether Alice will she win if input n=i
        // for input n==1 Alices loses
        dp[1] = false;

        // bottom up - start building answers for smaller n
        for (int i = 2; i <= n; i++) {
            dp[i] = false;
            for (int x = 1; x <= i / 2; x++) {
                // for every divisor
                // if dp[i-x]==false then for current input Alice wins,
                // as next step is a losing state which will be played by bob
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("\n" + divisorGame(2));
    }

}

// greedy soln
// Part 1) If Alice starts with an even number she will always win.

// If Alice has an even number, she can always subtract 1, giving Bob an odd
// number. Odd numbers are not divisible by 2. They are only divisible by odd
// numbers. Hence Bob must subtract an odd number. Since odd minus odd is even,
// Bob will always return an even number to Alice. Alice will thus get a smaller
// even number after each round of play and Bob will get a smaller odd number
// after each round of play. Eventually Bob will have to play the number 1 and
// will lose the game since he will have no options.

// Part 2) If Alice starts with an odd number she will always lose.

// If Alice has an odd number, she has no choice but to subtract an odd number
// as odd numbers have no even divisors. Thus Bob will get an even number. Now
// using the argument from Part 1 above, Bob can take this even number and keep
// giving an odd number back to Alice by subtracting 1. Thus Bob will always get
// to play even and Alice will always be stuck with an odd number smaller than
// her previous odd number after each round. Eventually Alice will have to play
// the number 1 and will lose the game since she will have no options.