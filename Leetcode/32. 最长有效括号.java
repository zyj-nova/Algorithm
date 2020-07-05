import java.util.LinkedList;

class Solution {
    public static int longestValidParentheses(String s) {
        // 栈的做法
        // 用一个栈来保存所有遇到的左括号的索引，
        // 当遇到一个右括号时，判断栈顶元素是否空，
        // 若不空，则出栈，然后那么当前索引-栈顶索引即为一个长度
        // 若空，则让当前索引（右括号的）入栈，充当分隔符
        LinkedList<Integer> stack = new LinkedList<>();
        int maxLen = 0;
        char ch[] = s.toCharArray();
        stack.push(-1);
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else {
                stack.pop(); // 第一次执行是把-1弹出栈
                if (stack.isEmpty()) {// 栈为空
                    stack.push(i); // 右括号入栈从当分隔符
                } else {// 栈不空
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()))"));
    }
}