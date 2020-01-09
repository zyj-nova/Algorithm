class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    /*
     * 1) Get the Middle of the array and make it root. 2) Recursively do same for
     * left half and right half. a) Get the middle of left half and make it left
     * child of the root created in step 1. b) Get the middle of right half and make
     * it right child of the root created in step 1.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int arr[], int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;// 有溢出的风险
        TreeNode root = new TreeNode(arr[mid]);
        root.left = generate(arr, start, mid - 1);
        root.right = generate(arr, mid + 1, end);
        return root;
    }

}