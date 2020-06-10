import java.util.LinkedList;

class Solution {
    public static String decodeString(String s) {
        LinkedList<String> strStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        int num = 0;
        String res = "";
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strStack.addFirst(res);
                numStack.addFirst(num);
                res = "";
                num = 0;
            } else if (c == ']') {
                int n = numStack.pollFirst();
                String tmp = strStack.pollFirst();
                String str = "";
                for (int i = 1; i <= n; i++) {
                    str += res;
                }

                res = tmp + str;
            } else {
                res += c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}