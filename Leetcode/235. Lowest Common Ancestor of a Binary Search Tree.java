class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * x 是 p、q 的祖先且 x 的深度尽可能大即x是p、q的最近的祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int pval = p.val;
        int qval = q.val;
        int rootval = root.val;
        // 根据二叉搜索树的性质来做
        // 1. 如果都比根节点的值大，说明在右子树
        // 2. 如果都比根节点的值小，说明在左子树
        // 3.否则，他俩分别在根节点的左右子树上，公共祖先结点当然是根节点了。返回根节点
        if (pval > rootval && qval > rootval)
            return lowestCommonAncestor(root.right, p, q);
        else if (pval < rootval && qval < rootval)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }

}