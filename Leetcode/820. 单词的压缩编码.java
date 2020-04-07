class Solution {
    class Trie {
        class TrieNode {
            char val;
            TrieNode children[] = new TrieNode[26];

            public TrieNode() {

            }

            public TrieNode(char ch) {
                this.val = ch;
            }

        }

        private TrieNode root = new TrieNode();

        public int insert(String word) {
            int len = word.length();
            boolean isNew = false;
            TrieNode cur = root;
            // 倒着插入！
            for (int i = len - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    isNew = true;
                    cur.children[ch - 'a'] = new TrieNode(ch);
                }
                cur = cur.children[ch - 'a'];
            }
            return isNew ? len + 1 : 0;
        }

        public boolean startsWith(String word) {
            int len = word.length();
            TrieNode cur = root;
            for (int i = len - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                TrieNode tmp = cur;
                for (TrieNode node : cur.children) {
                    if (node != null && node.val == ch) {
                        cur = node;
                        break;
                    }
                }
                if (cur == tmp) {
                    return false;
                }
            }
            return true;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        int ans = 0;
        Trie tree = new Trie();
        for (int i = 0; i < words.length; i++) {
            ans += tree.insert(words[i]);
        }
        return ans;
    }
}