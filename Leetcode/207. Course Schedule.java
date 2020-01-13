import java.util.Queue;

class Solution {
    /*
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 
     * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
     * 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 完成图的拓扑排序
        int indegre[] = new int[numCourses];
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
        return numCourses == 0;
    }
}