class Trie {
    static class TrieNode {
        char val;
        boolean isEnd = false;
        TrieNode children[] = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char ch) {
            this.val = ch;
        }
    }

    private TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode cur = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
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
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
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

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */