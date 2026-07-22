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
   public TreeNode calculateMaxSumRootToLeaf(TreeNode node) {
        if (node == null) return null;

        TreeNode rtl = new TreeNode(0);
        rtl.left = calculateMaxSumRootToLeaf(node.left);
        rtl.right = calculateMaxSumRootToLeaf(node.right);
        
        int v1 = node.val;
        int v2 = node.val + (rtl.left != null ? rtl.left.val : 0);
        int v3 = node.val + (rtl.right != null ? rtl.right.val : 0);

        rtl.val = Math.max(v1, Math.max(v2, v3));
        return rtl;
    }

    public void calculateMaxPath(TreeNode node, TreeNode maxSumRootToLeaf) {
        if (node == null) return;

        int v1 = node.val;
        int v2 = node.val + (node.left != null ? maxSumRootToLeaf.left.val : 0);
        int v3 = node.val + (node.right != null ? maxSumRootToLeaf.right.val : 0);
        int v4 = node.val + (node.left != null ? maxSumRootToLeaf.left.val : 0) + (node.right != null ? maxSumRootToLeaf.right.val : 0);

        node.val = Math.max(Math.max(v1, v2), Math.max(v3, v4));

        calculateMaxPath(node.left, maxSumRootToLeaf.left);
        calculateMaxPath(node.right, maxSumRootToLeaf.right);
    }

    public int calculateMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        return Math.max(node.val, Math.max(calculateMax(node.left), calculateMax(node.right)));
    }

    public int maxPathSum(TreeNode root) {
        TreeNode maxSumRootToLeaf = calculateMaxSumRootToLeaf(root);
        calculateMaxPath(root, maxSumRootToLeaf);
        return calculateMax(root);
    }
}
