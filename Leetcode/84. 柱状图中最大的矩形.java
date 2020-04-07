class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            int width = 1;
            for (int j = i + 1; j < len; j++) {
                if (heights[j] >= h) {
                    width++;
                } else {
                    break;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= h) {
                    width++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, width * h);
        }
        return ans;
    }
}