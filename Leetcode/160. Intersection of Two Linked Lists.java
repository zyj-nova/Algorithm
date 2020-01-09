public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 找到两个链表的公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lena = 0, lenb = 0;
        ListNode heada = headA, headb = headB;
        while (heada != null) {
            heada = heada.next;
            lena++;
        }
        while (headb != null) {
            headb = headb.next;
            lenb++;
        }
        if (lena > lenb) {
            for (int i = 1; i <= lena - lenb; i++)
                headA = headA.next;
        } else {
            for (int i = 1; i <= lenb - lena; i++)
                headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}