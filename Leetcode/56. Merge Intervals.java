import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // 二维数组排序，以第一列元素整体排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0, len = intervals.length;
        while (i < len) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < len - 1 && right >= intervals[i + 1][0]) {

                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            ans.add(new int[] { left, right });
            i++;
        }
        return ans.toArray(new int[0][]);
    }
}