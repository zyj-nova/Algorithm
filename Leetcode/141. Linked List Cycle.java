class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * 给定一个链表，判断链表中是否有环。 1.利用集合：每访问一个结点，判断其是否被访问过，如果访问过，返回 true ，否则，将其加入集合，继续判断
     * 2.利用双指针：前后两个指针，如果存在环，fast会在多轮之后与slow重合。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}