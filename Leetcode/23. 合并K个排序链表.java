/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        int len = lists.length;
        for (int i = 0; i < len; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        // 将链表a和b合并为一个有序链表
        ListNode pa = a;
        ListNode pb = b;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                ans.next = pa;
                pa = pa.next;
            } else {
                ans.next = pb;
                pb = pb.next;
            }
            ans = ans.next;
        }
        ans.next = pa == null ? pb : pa;
        return head.next;
    }
}