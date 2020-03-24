import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 暴力解法 O(n2)
        // 利用栈 O(n) 只扫描一次
        int ans[] = new int[T.length];
        LinkedList<Integer> st = new LinkedList<>();// 栈用来保存下标
        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                // 如果元素大于栈顶元素，出栈，是一个递减栈 栈底元素 > 栈顶元素
                int t = st.pop();
                ans[t] = i - t;
            }
            st.push(i);
        }
        return ans;
    }
    // input:[73, 74, 75, 71, 69, 72, 76, 73]
    // output:[1, 1, 4, 2, 1, 1, 0, 0]
}