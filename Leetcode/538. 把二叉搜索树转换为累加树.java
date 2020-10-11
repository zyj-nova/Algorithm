/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int sum = 0;
    // 思路：二叉树的逆中序遍历，原来中序遍历是“左根右”会形成一个递增序列；逆中序遍历即“右根左”形成一个递减序列，遍历到那个节点
    // 将其节点值更新为sum即可。
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}