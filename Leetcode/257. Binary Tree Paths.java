import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /*
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 
     * 说明: 叶子节点是指没有子节点的节点。
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null)
            return res;
        // 非递归
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        LinkedList<String> path = new LinkedList<>();
        path.push(String.valueOf(root.val));
        TreeNode top;
        String p;
        while (!stack.isEmpty()) {
            top = stack.pop();
            p = path.pop();
            if (top.left == null && top.right == null) {
                res.add(p);
                continue;
            }
            if (top.right != null) {
                stack.push(top.right);
                path.push(p + "->" + String.valueOf(top.right.val));
            }
            if (top.left != null) {
                stack.push(top.left);
                path.push(p + "->" + String.valueOf(top.left.val));
            }

        }
        return res;
    }

    private void dfs(TreeNode root, List<String> list, String res) {
        res += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(res);
            return;
        }
        if (root.left != null) {
            dfs(root.left, list, res + "->");
        }
        if (root.right != null) {
            dfs(root.right, list, res + "->");
        }
    }
}