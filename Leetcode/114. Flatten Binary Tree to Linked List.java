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

    // 给定一个二叉树，原地将它展开为链表。
    // 先序遍历的同时，该变树结点的right指向。
    // right 视为 next指针。left 对应 prev指针
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> ans = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.addLast(top);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        root = ans.get(0);
        root.left = null;
        TreeNode head = root;
        int len = ans.size();
        for (int i = 1; i < len; i++) {
            TreeNode tmp = ans.get(i);
            tmp.left = null;
            head.right = tmp;
            head = tmp;
        }
    }
}