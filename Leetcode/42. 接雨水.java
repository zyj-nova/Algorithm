class Solution {
    public static int trap(int[] height) {
        // 解法1 O(n2)
        // int len = height.length;
        // int ans = 0;
        // for (int i = 1; i < len - 1; i++) {
        // int max_right = 0;
        // int max_left = 0;
        // for (int j = i - 1; j >= 0; j--) {
        // max_left = Math.max(height[j], max_left);
        // }

        // for (int j = i + 1; j < len; j++) {
        // max_right = Math.max(height[j], max_right);
        // }
        // int min = Math.min(max_right, max_left);
        // if (height[i] < min) {
        // ans += (min - height[i]);
        // }
        // }
        // return ans;

        // 解法2：由于每次都要扫描左右边最大高度值，因此可以用dp的方法提前存储下来
        int len = height.length;
        int ans = 0;
        int max_left[] = new int[len];
        int max_right[] = new int[len];
        // 要注意的是，max_left[i-1]存储的是i-1之前最大的元素(不包含i-1)
        // 因此，求max_left[i]时，需要在max_left[i-1]和height[i-1]之间取最大值！
        // 就是因为max_left[i-1]不包含height[i]，dp数组就是存储i之前最大的元素
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i + 1], max_right[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (height[i] < min) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}