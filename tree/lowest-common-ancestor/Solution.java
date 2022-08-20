//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Solution {
    
    //great problem on dfs

    
}
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode trp, TreeNode trq) {
//         if((trp!=null && root.val == trp.val )|| (trq!=null && root.val == trq.val))
//             return new TreeNode(root.val);
//         Map<Integer,Integer> p = new HashMap<>();
//          Map<Integer,Integer> d = new HashMap<>();
//         boolean[] used = new boolean[2]; //graph
//         Deque<TreeNode>q = new LinkedList<>();
//         p.put(root.val,1000000009);
//         d.put(root.val,  0);
//         q.add(root);
//         TreeNode it;
//         while(!q.isEmpty() && !(used[0] && used[1])){
//             it = q.remove();
//             int rv = -1, lv = -1;
//             if(it.left != null){
//                 rv = it.left.val;
//                 q.add(it.left);
//                 d.put(it.left.val, d.get(it.val) + 1);
//                 p.put(it.left.val, it.val);
//             }
            
//             if(it.right !=null){
//                 lv = it.right.val;
//                 q.add(it.right);
//                 d.put(it.right.val, d.get(it.val) + 1);
//                 p.put(it.right.val, it.val);
//             }
            
//             if(trp.val == rv || trp.val == lv)
//                 used[0]=true;
//             if(trq.val == rv || trq.val == lv)
//                 used[1]=true;
//         }
        
//         int a = trq.val, b = trp.val;
//         while(d.get(a) != d.get(b)){
//            if(d.get(a)>d.get(b))
//                 a=p.get(a);
//             else
//                 b=p.get(b);
//         }
//         while(a!=b){
//             a=p.get(a);
//             b=p.get(b);
//         }
//         return new TreeNode(a);
//     }
// }
// //doing this with bfs results in too much code and might be
// //slower approach
