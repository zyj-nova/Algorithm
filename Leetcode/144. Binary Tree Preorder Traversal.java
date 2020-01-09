import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 给定一个二叉树，用迭代法求出他的前序遍历
    // 深搜-栈实现 首先将根结点入栈，然后当栈不空时进行循环，首先将栈顶元素出栈，并将节点值加到结果集中，
    // 将栈顶元素的右孩子、左孩子依次入栈。
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(top.val);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        return res;
    }
}