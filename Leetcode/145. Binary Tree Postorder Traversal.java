import java.util.ArrayList;
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

    public static class Command {
        String com;
        TreeNode t;

        Command(String s, TreeNode p) {
            com = s;
            t = p;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<Command> s = new LinkedList<>();
        s.push(new Command("go", root));
        while (!s.isEmpty()) {
            Command top = s.pop();
            if (top.com.equals("print")) {
                ans.add(top.t.val);
            } else {
                s.push(new Command("print", top.t));
                if (top.t.right != null) {
                    s.push(new Command("go", top.t.right));
                }
                if (top.t.left != null) {
                    s.push(new Command("go", top.t.left));
                }
            }
        }
        return ans;
    }
}