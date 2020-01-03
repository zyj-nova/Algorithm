/*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    1 1 2 2 3
*/

public static ListNode deleteDuplication(ListNode pHead) {
    if (pHead == null || pHead.next == null)
        return pHead;
    ListNode ans = new ListNode(0);
    ans.next = pHead;
    ListNode pre = ans, cur = pHead;
    while (cur!=null && cur.next!=null){
        if (cur.val == cur.next.val){
            int val = cur.val;
            while (cur!=null && cur.val == val)
                cur = cur.next;
            pre.next = cur;
        }else{
            pre = cur;
            cur = cur.next;
        }
    }
    return ans.next;
}