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

//too hard required good observation and good coding
//https://leetcode.com/problems/all-possible-full-binary-trees/
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

    List<List<TreeNode>> dp = new ArrayList<>();
    public List<TreeNode> allPossibleFBT(int n) {
        for(int i =0;i<=n;i++)
            dp.add(new ArrayList<>());
      return pick(n);
    }
    
    List<TreeNode> pick(int n){
        if(dp.get(n).size() != 0)
            return dp.get(n);
        if(n==1)
            return Arrays.asList(new TreeNode(0));
        if(n==2)
            return new ArrayList<>();
        List<TreeNode> subAns = new ArrayList<>();
        for(int i = 1; i <= (n-1)/2; i++){
            List<TreeNode> left = pick(i);
            if(left != null){
                List<TreeNode> right = pick(n-i-1);
                if( right != null){
                    for(TreeNode l : left){
                        for(TreeNode r: right){
                            subAns.add( new TreeNode(0,l, r));
                            if(i != n-i-1)
                               subAns.add( new TreeNode(0,r, l)); 
                        }
                    }
                }
            }
            else{
                 List<TreeNode> right = pick(n-i-1);
                if( right == null){
                    subAns.add( new TreeNode(0));
                }
            }
        }
        if(! subAns.isEmpty())
            dp.add(n, subAns);
        return dp.get(n); 
    }

    public static void main(String[] args) {

    }
}