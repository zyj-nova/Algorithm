public class Solution{
    public static int lengthOfLongestSubstring(String s) {
        char ch[] = s.toCharArray();

        int len = ch.length, i = 0, j = 0;
        int ans = 0;
//        //滑动窗口解法
//        HashSet<Character> set = new HashSet<>();
//        while (i < len && j < len){
//            if (!set.contains(ch[j])){
//                set.add(ch[j++]);
//                ans = Math.max(ans, j - i );
//            }else{
//                set.remove(ch[i++]);
//            }
//        }
        //优化的滑动窗口
        HashMap<Character,Integer> map = new HashMap<>();
        for (; j < len; j++){
            if (map.containsKey(ch[j])){
                i = Math.max(map.get(ch[j]),i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(ch[j], j + 1);
        }
        return ans;
    }
}