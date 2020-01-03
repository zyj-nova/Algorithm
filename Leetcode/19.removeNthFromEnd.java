//仅一次遍历，删除链表中倒数第k个结点
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy,second = dummy;
    for (int i = 0; i < n + 1; i++){
        //向后移动 n + 1步
        first = first.next;
    }
    while (first!=null){
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;

    return dummy.next;
}