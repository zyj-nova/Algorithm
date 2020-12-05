class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 1, len = intervals.length;
        if (len <= 0){
            return 0;
        }
        // 重叠区间 [a,b] [c,d] b > c
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));
        int boundary = intervals[0][1];//右边界

        for (int i = 1; i < len; i++){//计算不重叠区间！
            if (boundary <= intervals[i][0]){
                ans++;
                boundary = intervals[i][1];
            }
        }
        return len - ans;
    }
}