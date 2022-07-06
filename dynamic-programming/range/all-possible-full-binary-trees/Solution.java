import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // 1 2 3 4 5 6 7 nodes
    // choose a root among the nodes to create subproblems
    // subproblems are intersecting so create dp
    // eg: n = 4
    // 1 2 3 4 nodes available
    // 4 (root)
    // /
    // (1 2 3)

    // n = 3
    // 1 2 3 nodes available
    // (1 2 3) subproblem can be used above for n=4

    public static List<TreeNode> allPossibleFBT(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();
        dp.add(Arrays.asList(new TreeNode(0)));
        if (n == 2)
            return Arrays.asList();
        if (n == 1)
            return dp.get(0);
        // divide into odd left part and right part
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                dp.add(Arrays.asList(new TreeNode(0)));
                continue;
            }

            for (int j = 1; j <= i; j += 2) {
                int left = j-1;
                int right = i-j;
            }
        }
    }

    public static void main(String[] args) {

    }
}