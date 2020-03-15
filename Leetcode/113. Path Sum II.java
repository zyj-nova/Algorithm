import java.util.ArrayList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        helper(root, new LinkedList<Integer>(), ans, sum);
        return ans;
    }

    private void helper(TreeNode root , LinkedList<Integer> tmp, List<List<Integer>> ans, int sum){
        if(root.left == null && root.right == null){///叶子节点
            if(root.val - sum == 0){
                tmp.add(root.val);
                LinkedList<Integer> p = (LinkedList<Integer>) tmp.clone();
                ans.add(p);
                tmp.removeLast();
                return ;
            }else{
                return ;
            }
        }
        tmp.add(root.val);
        if(root.left!=null){
            helper(root.left, tmp, ans, sum - root.val);
        }
        if(root.right!=null){
            helper(root.right, tmp, ans, sum - root.val);
        }
        tmp.removeLast();
    }
}