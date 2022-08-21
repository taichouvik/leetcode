import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null)
            q.add(root);
        int i = 1;
        int c = 0;
        while (!q.isEmpty()) {
            int ti = 0;

            Deque<Integer> sub = new LinkedList<>();

            while (i-- > 0) {
                TreeNode temp = q.remove();
                if (temp == null)
                    continue;

                if (temp.left != null) {
                    q.add(temp.left);
                    ti++;
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    ti++;
                }

                if ((c & 1) == 0) {
                    sub.add(temp.val);
                } else
                    sub.addFirst(temp.val);

            }
            c++;
            i = ti;
            ans.add((List<Integer>) sub);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        sol.zigzagLevelOrder(t);
    }

}