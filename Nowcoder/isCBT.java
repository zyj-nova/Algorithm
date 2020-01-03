public class Solution {
    // 判断一棵树是否为完全二叉树
    public static boolean isCBT(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode L, R, tmp;
        queue.offer(root);
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            L = tmp.left;
            R = tmp.right;
            if (L == null && R != null) {
                return false;
            }
            if (leaf && (L != null || R != null)) {
                return false;
            }
            // 只要左右子树不都存在，leaf标志位就设为true
            if (L != null)
                queue.offer(L);
            if (R != null)
                queue.offer(R);
            else
                leaf = true;
        }
        return true;
    }
}