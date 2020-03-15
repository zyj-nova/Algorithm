class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 两结点之间的路径长度是以它们之间边的数目表示
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        routeLength(root);
        return ans - 1;
    }

    private int routeLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = routeLength(root.left);
        int R = routeLength(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}