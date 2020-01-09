import java.util.ArrayList;
import java.util.List;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] convertListtoArray(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int res[] = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            res[i] = nodes.get(i);
        }
        return res;
    }

    private TreeNode sortdArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortdArrayToBST(arr, start, mid - 1);
        root.right = sortdArrayToBST(arr, mid + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int nums[] = convertListtoArray(head);
        return sortdArrayToBST(nums, 0, nums.length - 1);
    }
}
