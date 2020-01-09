class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int tmp = cur.val;
                while (cur != null && cur.val == tmp) {
                    cur = cur.next;
                }
                prev.next = cur;// 断开重复的元素
                // 写在else语句中，当后面全是重复元素就失效了,或者连着重复元素。 3 3 4 4，
                // 只是跳过了。并没有断开
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}