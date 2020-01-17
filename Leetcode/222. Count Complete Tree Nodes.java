import java.util.LinkedList;

class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 给定一个完全二叉树，求他的节点个数
    // 层次遍历，统计---非最优、时间复杂度O（n）
    // 优化 时间复杂度 O(logn)/类似于二分
    // 完全二叉树的性质：
    // 无非两种情况：
    // 1.左右子树高度相同。此时，左子树一定是满二叉树，右子树不确定是不是完全二叉树.可根据公式直接算出左子树节点数，递归遍历右子树
    // 2.左右子树高度差1。此时，右子树一定是满二叉树。可根据公式直接算出右子树节点数，递归遍历左子树。
    private int countLevel(TreeNode p) {
        if (p == null)
            return 0;
        int depth = 1;
        while (p.left != null) {
            depth++;
            p = p.left;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 1;
        int lheight = countLevel(root.left);
        int rheight = countLevel(root.right);
        if (lheight == rheight) {
            ans += (1 << lheight) - 1;// 算出左子树
            // 递归遍历右子树
            return ans + countNodes(root.right);
        } else {
            ans += (1 << rheight) - 1;
            return ans + countNodes(root.left);
        }

    }
}