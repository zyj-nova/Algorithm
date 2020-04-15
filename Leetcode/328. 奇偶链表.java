class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode pointer = head;
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(-1);
        ListNode dummy = second;
        int cnt = 1;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = null;
            if (cnt % 2 != 0) {// 奇结点
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            cnt++;
            head = tmp;
        }
        first.next = dummy.next;
        return pointer;
    }
}