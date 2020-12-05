class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len <= 0){
            return 0;
        }
        // 刺破所有气球所需的最小弓箭数,如果区间不相交，则需要气球个
        int ans = 1;
        // 排序 按照右端点从小到大排序注意：不要用a[1]-b[1]这样的判断方式，可能会越界！！
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        int arrow = points[0][1];
        for(int i = 1; i < len; i++){
            if (arrow < points[i][0]){// 右端点小于下一个气球的起始坐标，需要另外一支箭
                ans++;
                arrow = points[i][1];
            }
            // 否则，一支箭可以继续射下去
        }

        return ans;
    }   
}