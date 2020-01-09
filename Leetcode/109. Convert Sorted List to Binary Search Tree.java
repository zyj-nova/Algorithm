class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * 
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 
     * 引申：如何在一个链表中，只扫描一遍，找到链表的中间结点？采用快慢指针，慢指针每次移动一步，
     * 快指针每次移动两个步，当快指针为null时，慢指针恰好处于链表中部
     * 
     * 第一种：采用和数组类似的找到中间结点，然后左右分别递归的方法
     * 
     * 第二种：链表转为数组，然后进行操作
     */
    private ListNode findMiddleElement(ListNode head) {
        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMiddleElement(head);

        TreeNode root = new TreeNode(mid.val);
        if (head == mid)// 注意递归中止条件
            return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}
