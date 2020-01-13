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

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Command> s = new LinkedList<>();
        s.push(new Command("go", root));
        while (!s.isEmpty()) {
            Command top = s.pop();
            if (top.com.equals("print")) {
                ans.add(top.t.val);
            } else {
                if (top.t.right != null) {
                    s.push(new Command("go", top.t.right));
                }
                s.push(new Command("print", top.t));
                if (top.t.left != null) {
                    s.push(new Command("go", top.t.left));
                }
            }
        }
        return ans;
    }
}