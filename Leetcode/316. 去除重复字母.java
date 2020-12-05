class Solution {
    public String removeDuplicateLetters(String s) {
        char ch[] = s.toCharArray();
        int maps[] = new int[26];
        for (int i = 0; i < ch.length; i++){
            maps[ch[i] - 'a']++;
        }
        // 难点在需要去重的同时保持字典序最小,同时还不能改变原有字符的相对位置
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (char c:ch){
            maps[c - 'a']--;
            if (stack.contains(c)){
                continue;
            }
            while (!stack.isEmpty() && maps[stack.peek() - 'a'] > 0 && stack.peek() > c){
                stack.pop();
            }
            stack.push(c);
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}