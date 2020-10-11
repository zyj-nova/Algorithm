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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 和有序数组中查找插入顺序差不多 二分
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode tmp = dfs(root, root, val);
        if (tmp.val > val){
            tmp.left = new TreeNode(val);
        }else{
            tmp.right = new TreeNode(val);
        }
        return root;
    }

    private TreeNode dfs(TreeNode root, TreeNode prev, int val){
        if (root == null){
            return prev;
        }
        if (root.val < val){
            return dfs(root.right, root, val);
        }else
            return dfs(root.left, root, val);
    }
}