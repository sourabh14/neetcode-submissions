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

class Solution {
    public int countGoodNodes(TreeNode node, int max) {
        if (node == null) return 0;

        int val = ((node.val >= max) ? 1 : 0) + countGoodNodes(node.left, Math.max(node.val, max)) +
                countGoodNodes(node.right, Math.max(node.val, max));
        return val;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}
