public class Solution {
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
    }

    /*
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 左右子树高度差 <= 1
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}