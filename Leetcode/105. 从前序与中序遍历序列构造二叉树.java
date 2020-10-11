class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int preleft, int preright, int inleft, int inright, int[] preorder, int[] inorder){
        if(inleft > inright){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        int index = inleft;
        // 在中序遍历结果中找到根节点，划分左子树和右子树
        while(inorder[index] != root.val){
            index ++;
        }
        // 左子树节点个数
        int cnt = index - inleft;
        root.left = build(preleft + 1, preleft + cnt, inleft, index - 1, preorder, inorder);
        root.right = build(preleft + cnt + 1, preright, index + 1, inright,preorder, inorder);
        return root;
    }
}