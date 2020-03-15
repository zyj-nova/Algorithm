import java.util.LinkedList;

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 简单的一种方法，中序遍历，看是否存在逆序。
     * 
     * 2 / \ 1 3
     * 
     * @param root
     * @return
     */

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur;
        double preVal = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            cur = stack.pop();
            if (cur.val <= preVal)
                return false;
            preVal = cur.val;
            root = cur.right;
        }
        return true;
    }
}