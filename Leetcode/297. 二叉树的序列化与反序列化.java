import java.util.LinkedList;

import jdk.nashorn.api.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 层次遍历
        StringBuilder res = new StringBuilder();
        res.append("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.pollFirst();
            if (top == null) {
                res.append("null,");
            } else {
                res.append(top.val + ",");
                queue.offerLast(top.left);
                queue.offerLast(top.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.[1,2,3,null,4]
    public TreeNode deserialize(String data) {
        String nodes[] = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        LinkedList<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;

        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Codec c = new Codec();
        System.out.println(c.serialize(root));
    }
}
