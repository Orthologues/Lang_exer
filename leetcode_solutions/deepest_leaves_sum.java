/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {

    Deque<Pair<Integer, TreeNode>> nodes_dq = new ArrayDeque<>();
    List<Integer> deepest_vals = new ArrayList<>();
    
    public int deepestLeavesSum(TreeNode root) {
        int max_depth = 1;
        // add the root node to the empty deque
        nodes_dq.add(new Pair<>(1, root));
        while (!nodes_dq.isEmpty()) {
            Pair<Integer, TreeNode> curr_pair = nodes_dq.pollFirst();
            int node_depth = curr_pair.getKey();
            // update the max depth of this tree
            if (node_depth > max_depth) {
                max_depth = node_depth;
                deepest_vals.clear();
            }
            TreeNode node = curr_pair.getValue();
            deepest_vals.add(node.val);
            if (node.left!=null) nodes_dq.add(new Pair<>(node_depth+1, node.left));
            if (node.right!=null) nodes_dq.add(new Pair<>(node_depth+1, node.right));
        }
        
        int sum = 0;
        for (int val: deepest_vals) {
            sum+=val;
        }
        return sum;
    }
}
