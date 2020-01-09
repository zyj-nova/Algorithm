class Solution {
    /*
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        for (int i = 1; i < row; i++) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                int r = 0;
                if (j == 0) {
                    r = tmp.get(j) + triangle.get(i - 1).get(j);
                } else if (j == tmp.size() - 1) {
                    r = tmp.get(j) + triangle.get(i - 1).get(j - 1);
                } else {
                    r = tmp.get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                }
                tmp.set(j, r);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < triangle.get(row - 1).size(); k++) {
            min = Math.min(min, triangle.get(row - 1).get(k));
        }
        return min;
    }
}