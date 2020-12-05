/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int dfs(TreeNode root, int num){
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            //叶子节点
            return num * 10 + root.val;
        }
        return dfs(root.left, num * 10 + root.val) + dfs(root.right, num *10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}