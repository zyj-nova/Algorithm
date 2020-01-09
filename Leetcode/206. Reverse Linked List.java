class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = null, next = null;
        while (head != null) {
            next = head.next;
            dummy.next = head;
            head.next = cur;
            cur = head;
            head = next;
        }
        return dummy.next;
    }
}