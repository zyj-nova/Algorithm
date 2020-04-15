import java.util.LinkedList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 解法1：将两个链表反转
        // 解法2：利用栈将两个链表值入栈
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s1.push(l2.val);
            l2 = l2.next;
        }
        // 两数相加注意进位问题,头插法返回列表
        ListNode head = new ListNode(0);
        int nums = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || nums > 0) {
            int tmp = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + nums;
            ListNode node = new ListNode(tmp % 10);
            nums += tmp / 10;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}