class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        // 法1：链表转数组
        // 法2：双指针 反转前半部分 由于是双指针，初始时，slow和fast指向head，修改slow.next会导致fast空指针，因此，需要额外申请空间存储。

        // ListNode fast = head, slow = head;
        // ListNode dummy = new ListNode(0);
        // ListNode t = null;
        // while (fast != null && fast.next != null) {
        // ListNode tmp = new ListNode(slow.val);
        // tmp.next = dummy.next;
        // dummy.next = tmp;
        // slow = slow.next;

        // fast = fast.next.next;
        // }

        // if (fast != null) {// 链表长度为奇数
        // slow = slow.next;
        // }

        // t = dummy.next;

        // while (t != null && slow != null) {
        // if (t.val != slow.val) {
        // return false;
        // }
        // t = t.next;
        // slow = slow.next;
        // }
        // return true;

        // 尝试反转后半部分，后半部分只存在slow指针，不存在反转前半部分的问题
        ListNode fast = head, slow = head;
        ListNode dummy = new ListNode(0);
        ListNode t = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {// 链表长度为奇数
            slow = slow.next;
        }
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = tmp;
        }
        t = dummy.next;
        while (t != null && head != null) {
            if (t.val != head.val) {
                return false;
            }
            t = t.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        System.out.println(isPalindrome(head));
    }
}