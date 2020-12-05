class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() < 2){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int last = num.length() - k;
        char ch[] = num.toCharArray();
        for (char c:ch){
            // 当栈顶数字大于当前数字时，栈顶数字出栈，直到小于为止
            while (k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        String tmp = res.reverse().toString();
        if (tmp.length() > last){
            tmp = tmp.substring(0, last);
        }
        if (tmp.length() == 0){
            return "0";
        }
        if (tmp.length() < 2){
            return tmp;
        }
        int index = 0;
        while ( index < tmp.length() && tmp.charAt(index) == '0'){
            index++;
        }

        return tmp.substring(index).equals("") ? "0" : tmp.substring(index);
    }
}