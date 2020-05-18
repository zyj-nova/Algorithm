
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null && t != null) {
            return false;
        }
        // 判断s的左子树是否包含t、判断s的右子树是否包含t、判断s是否与t完全相等
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if ((t == null && s != null) || (t != null && s == null)) {
            return false;
        }
        if (t.val == s.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            return false;
        }

    }
}