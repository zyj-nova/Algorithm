import java.util.LinkedHashMap;
import java.util.LinkedList;

class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private LinkedList<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        // 实现非递归中序遍历，将结点从小到大插入队列中。
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            queue.offer(cur.val);
            cur = cur.right;
        }
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size() == 0 ? false : true;
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */