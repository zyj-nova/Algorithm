import java.util.ArrayList;
import java.util.Queue;

import javax.management.Query;

class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode top = q.poll();
                tmp.add(top.val);
                if (top.left != null)
                    q.offer(top.left);
                if (top.right != null)
                    q.offer(top.right);
            }
            res.add(tmp);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;
    }
}