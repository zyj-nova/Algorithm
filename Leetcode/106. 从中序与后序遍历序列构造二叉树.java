/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // postorder最后一个元素为树的根节点， 在inorder中找到该元素，之前的为左子树，后面为右子树，
        // postorder序列中根节点前一个节点为右子树的根节点，然后继续在inorder中找到该元素，划分左右子树
        return preorder(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    /**
        leftin : 中序序列 左指针
        rightin : 中序序列 右指针
        leftpost : 后序序列中 左指针
        rightpost : 后序序列 右指针
    
     */
    private TreeNode preorder(int leftin, int rightin, int leftpost, int rightpost, int[] inorder, int[] postorder){
        if(leftin > rightin){
            return null;
        }
        TreeNode root = new TreeNode(postorder[rightpost]);
        // 在中序遍历中找到左子树的范围
        int index = rightin;
        while(inorder[index] != root.val){
            index--;
        }
        // 左子树的节点个数
        int cnt = index - leftin;
        // 左子树在中序、后序中的范围
        root.left = preorder(leftin, index - 1, leftpost, leftpost + cnt - 1, inorder, postorder);
        // 右子树在中序、后序中的范围
        root.right = preorder(index + 1, rightin, leftpost + cnt, rightpost - 1, inorder, postorder);

        return root;
    }
}