import java.util.Deque;
import java.util.LinkedList;
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
    // https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
    //simple trick to calculate number of children in the queue that need to be removed for current level
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        int i = 1;
        List<List<Integer>> ans = new LinkedList<>();
        while (!q.isEmpty()) {
            int ti = 0;
            List<Integer> sub = new LinkedList<>();
            while (i-- > 0) {
                TreeNode t = q.remove();
                if (t.left != null) {
                    q.add(t.left);
                    ti++;
                }
                if (t.right != null) {
                    q.add(t.right);
                    ti++;
                }
                sub.add(t.val);
            }
            ans.add(sub);
            i = ti;

        }
        return ans;
    }
}