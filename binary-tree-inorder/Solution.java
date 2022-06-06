import java.util.ArrayList;
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
    List<Integer> order = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return order;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            order.add(root.val);
            return;
        }
        inOrder(root.left);
        order.add(root.val);
        inOrder(root.right);
    }
}