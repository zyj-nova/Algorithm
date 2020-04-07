import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        LinkedList<String> queue = new LinkedList<>();
        boolean visited[] = new boolean[wordList.size()];
        queue.offer(beginWord);
        int ans = 1;
        while (!queue.isEmpty()) {
            ans++;
            // 扫描这一层的单词
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) {
                        continue;
                    }
                    String s = wordList.get(j);

                    if (canChange(s, tmp)) {
                        if (s.equals(endWord)) {
                            return ans;
                        }
                        queue.offer(s);
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean canChange(String s, String t) {
        int diff = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
