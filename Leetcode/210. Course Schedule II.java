class Solution {
    // 题目和课程表I一样
    // 现在要返回课程顺序。
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 完成图的拓扑排序
        int indegre[] = new int[numCourses];
        int res[] = new int[numCourses];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int p[] : prerequisites) {// 统计所有课程的先修课程数目
            indegre[p[0]]++;
        }
        for (int i = 0; i < indegre.length; i++) {
            if (indegre[i] == 0)
                queue.addLast(i);// 第i门课程没有先修课程，先入队
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            res[index++] = pre;
            numCourses--;
            // 表示该门课程修完了，这门课是其他课程的先修课的课程先修课-1
            for (int p[] : prerequisites) {
                if (p[1] == pre) {
                    indegre[p[0]]--;
                    if (indegre[p[0]] == 0)
                        queue.addLast(p[0]);
                }
            }
        }
        if (numCourses == 0) {
            return res;
        } else {
            return new int[0];
        }
    }
}