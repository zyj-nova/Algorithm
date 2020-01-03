public class Solution{
     /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */
    public static boolean isValid(String s) {
        char ch[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[')
                stack.push(ch[i]);
            else{
                if (stack.empty()){
                    return false;
                }
                char tmp = stack.pop();
                if (ch[i] == ')' && tmp != '(')
                    return false;
                else if (ch[i] == ']' && tmp != '[')
                    return false;
                else if (ch[i] == '}' && tmp != '{')
                    return false;
                else
                    continue;
            }
        }
        return stack.empty();
    }
}