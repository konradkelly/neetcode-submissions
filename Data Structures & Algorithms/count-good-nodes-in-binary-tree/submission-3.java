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
    public int goodNodes(TreeNode root) {
        int res = 0;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        nodeStack.push(root);
        maxStack.push(Integer.MIN_VALUE);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int maxVal = maxStack.pop();
            if (node.val >= maxVal) res++;
            int newMax = Math.max(maxVal, node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
                maxStack.push(newMax);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                maxStack.push(newMax);
            }
        }
        return res;
    }
}
