package problems.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCA {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //solution #2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        helper(map, root, p);
        helper(map, root, q);
        //
        //now put all ancestors of p in a set
        Set<TreeNode> set = new HashSet<>();
        TreeNode temp = p;
        while(map.get(temp) != null) {
            set.add(map.get(temp));
            temp = map.get(temp);
        }
        TreeNode result = null;
        //Now go through all the parents of q until you find one in set of p's parents
        while(!set.contains(map.get(q))) {
            q = map.get(q);
        }
        return q;
    }

    private void helper(Map<TreeNode, TreeNode> map, TreeNode node, TreeNode x) {
        if (node == x || node == null) {
            return;
        } else {
            map.put(node.left, node);
            map.put(node.right, node);
            helper(map, node.left, x);
            helper(map, node.right, x);
        }
    }
}
